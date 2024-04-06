import kotlinx.coroutines.channels.Channel
import request.FullRequest
import request.RequestContext
import response.CommandResponse
import response.ResponseStatus

class RequestProcessor(
    private val commandExecutor: CommandExecutor,
    private val requestChannel: Channel<FullRequest>,
    private val clientChannel: Channel<CommandResponse>,
    private val serverChannel: Channel<CommandResponse>,
) {
    suspend fun run() {
        while (true) {
            val fullRequest = requestChannel.receive()
            val response = commandExecutor.execute(fullRequest.request)
            when (response.status) {
                ResponseStatus.ExecutionError -> {
                    ServerUDP.logger.error("Команда ${fullRequest.request.type} завершена с ошибкой")
                }
                ResponseStatus.Successfully -> {
                    ServerUDP.logger.info("Команда ${fullRequest.request.type} успешно обработана")
                }
            }
            when (fullRequest.context) {
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
