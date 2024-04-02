import commands.ACommand
import commands.CommandType

class CommandHandler(private val commands: Map<CommandType, ACommand>) {
    fun getCommands(): Map<CommandType, ACommand> {
        return commands
    }
}