import kotlinx.coroutines.channels.Channel
import request.FullRequest
import request.RequestContext
import response.CommandResponse

class RequestProcessor(private val commandExecutor: CommandExecutor, private val requestChannel: Channel<FullRequest>, private val clientChannel: Channel<CommandResponse>, private val serverChannel: Channel<CommandResponse>) {
    suspend fun run(){
        while (true){
            val fullRequest = requestChannel.receive()
            val response = commandExecutor.execute(fullRequest.request)
            when (fullRequest.context){
                RequestContext.SERVER -> {
                    serverChannel.send(response)
                }
                RequestContext.CLIENT -> {
                    clientChannel.send(response)
                }
            }
        }
    }
}
