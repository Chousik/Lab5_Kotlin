
import commands.CommandType
import database.SqlDB
import request.Request
import request.RequestClient
import response.CommandResponse
import response.ResponseStatus

class RequestProcessor(
    private val commandExecutor: CommandExecutor,
    private val sqlDB: SqlDB,
) {
    fun process(requestClient: RequestClient): CommandResponse {
        var response = sqlDB.login(requestClient.authorizationData)
        if (requestClient.request.type == CommandType.Authorization || response.status == ResponseStatus.ExecutionError){
            return response
        }
        return process(requestClient.request)
    }
    fun process(request: Request): CommandResponse {
        val response = commandExecutor.execute(request)
        when (response.status) {
            ResponseStatus.ExecutionError -> {
                ServerUDP.logger.error("Команда ${request.type} завершена с ошибкой")
            }
            ResponseStatus.Successfully -> {
                ServerUDP.logger.info("Команда ${request.type} успешно обработана")
            }
        }
        return response
    }
}
