package org.example

import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress

class Client(private val ipNet: InetAddress, private val port: Int) {
    private val datagramSocket = DatagramSocket()
}