import request.Request
import response.CommandResponse
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.nio.ByteBuffer
import java.net.InetSocketAddress
import java.nio.channels.DatagramChannel

class ServerUDP(port: Int = 1488) {
    private val channel: DatagramChannel = DatagramChannel.open()
    private var inetSocketAddress: InetSocketAddress? = null
    private val buffer = ByteBuffer.allocate(2048)
    init {
        channel.socket().bind(InetSocketAddress(port))
    }
    fun readRequest(): Request{
        inetSocketAddress = channel.receive(buffer) as InetSocketAddress
        buffer.flip()
        val data = ByteArray(buffer.remaining())
        buffer.get(data)
        val bais = ByteArrayInputStream(data)
        val ols = ObjectInputStream(bais)
        val request: Request = ols.readObject() as Request
        ols.close()
        buffer.clear()
        return request
    }
    fun sendResponse(response: CommandResponse){
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(response)
        oos.flush()
        val responseData = baos.toByteArray()
        channel.send(ByteBuffer.wrap(responseData), inetSocketAddress!!)
    }
}