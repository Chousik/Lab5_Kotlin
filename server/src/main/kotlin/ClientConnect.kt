import java.util.concurrent.ExecutorService

class ClientConnect(
    private val responseThreadPool: ExecutorService,
    private val serverUDP: ServerUDP,
    private val requestProcessor: RequestProcessor
) {
   fun run() {
        while (true) {
            val (request, inetSocketAddress) = serverUDP.readRequest()
            responseThreadPool.execute{
                val response = requestProcessor.process(request)
                serverUDP.sendResponse(response, inetSocketAddress!!)

            }
        }
    }
}
