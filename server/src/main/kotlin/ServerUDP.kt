import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress

class Server(private val commandE: CommandExecutor, private val ipNet: InetAddress = InetAddress.getLocalHost(), private val port: Int = 1488) {
    private val inetSocketAddress = InetSocketAddress(ipNet, port)
    private val datagramSocket = DatagramSocket(inetSocketAddress)

}