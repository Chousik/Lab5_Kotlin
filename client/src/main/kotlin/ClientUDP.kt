package org.example

import request.Request
import response.CommandResponse
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class ClientUDP(private val ipNet: InetAddress = InetAddress.getByName("localhost"), private val port: Int = 1488) {
    private val datagramSocket = DatagramSocket()

    init {
        datagramSocket.soTimeout = 5000
    }

    fun sendRequest(request: Request) {
        var baos = ByteArrayOutputStream()
        var oos = ObjectOutputStream(baos)
        oos.writeObject(request)
        oos.flush()
        var data = baos.toByteArray()
        var packet = DatagramPacket(data, data.size, ipNet, port)
        datagramSocket.send(packet)
    }

    fun readResponse(): CommandResponse {
        val buffer = ByteArray(2048)
        var responsePacket = DatagramPacket(buffer, buffer.size)
        datagramSocket.receive(responsePacket)
        var data = responsePacket.data
        val bais = ByteArrayInputStream(data)
        val ols = ObjectInputStream(bais)
        var response = ols.readObject() as CommandResponse
        ols.close()
        return response
    }
}
