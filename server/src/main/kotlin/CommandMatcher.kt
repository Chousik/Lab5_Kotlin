import commands.ACommand
import commands.CommandType

class CommandMatcher(private val commands: Map<CommandType, ACommand>) {
    fun getCommands(): Map<CommandType, ACommand> {
        return commands
    }
}
