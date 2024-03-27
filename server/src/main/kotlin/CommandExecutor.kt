import commands.ACommand
import request.Request
import response.CommandResponse
import response.ResponseStatus

class CommandExecutor(private val commandHandler: CommandHandler) {
    public fun execute(request: Request): CommandResponse{
        var command: ACommand? = commandHandler.getCommands()[request.type]
        return command?.execute(request.argument) ?: return CommandResponse(ResponseStatus.ExecutionError, "Команда не найдена! Повторите")

    }
}