import kotlinx.coroutines.channels.Channel
import request.FullRequest
import request.RequestContext
<<<<<<< HEAD
import response.CommandResponse
=======
import response.ResponseStatus
import java.util.concurrent.ExecutorService
import java.util.concurrent.locks.ReentrantLock
>>>>>>> 40cc7ce (add_ReentrantLock)

class ClientConnect(
    private val requestChanel: Channel<FullRequest>,
    private val responseChanel: Channel<CommandResponse>,
    private val serverUDP: ServerUDP,
) {
    suspend fun run() {
        while (true) {
<<<<<<< HEAD
            val request = serverUDP.readRequest()
=======
            val lock = ReentrantLock()
            val (request, inetSocketAddress) = serverUDP.readRequest()
            var response = sqlDB.login(request.authorizationData!!)
            if (request.type == CommandType.Authorization || response.status == ResponseStatus.ExecutionError){
                responseThreadPool.execute{
                    serverUDP.sendResponse(response, inetSocketAddress!!)
                }
                continue
            }
>>>>>>> 40cc7ce (add_ReentrantLock)
            val fullRequest = FullRequest(request, RequestContext.CLIENT)
            requestChanel.send(fullRequest)
            val response = responseChanel.receive()
            serverUDP.sendResponse(response)
        }
    }
}
