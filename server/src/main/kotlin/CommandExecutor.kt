import commands.ACommand
import request.Request
import response.CommandResponse
import response.ResponseStatus

class CommandExecutor(private val commandMatcher: CommandMatcher) {
    fun execute(request: Request): CommandResponse {
        val command: ACommand? = commandMatcher.getCommands()[request.type]
        return command?.execute(request.argument) ?: return CommandResponse(ResponseStatus.ExecutionError, "Команда не найдена! Повторите")
    }
}
