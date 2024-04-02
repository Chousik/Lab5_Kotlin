import kotlinx.coroutines.channels.Channel
import request.FullRequest
import request.RequestContext
import response.CommandResponse

class ClientConnect(private val requestChanel: Channel<FullRequest>, private val responseChanel: Channel<CommandResponse>, private val serverUDP: ServerUDP) {
    suspend fun run(){
        while (true){
            val request = serverUDP.readRequest()
            val fullRequest = FullRequest(request, RequestContext.CLIENT)
            requestChanel.send(fullRequest)
            val response = responseChanel.receive()
            serverUDP.sendResponse(response)
        }
    }
}