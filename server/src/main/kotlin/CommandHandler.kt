import commands.ACommand
import commands.CommandType

class CommandHandler(private val commands: HashMap<CommandType, ACommand>) {

    fun addCommand(commandType: CommandType, aCommand: ACommand) {
        commands[commandType] = aCommand
    }

    fun getCommands(): HashMap<CommandType, ACommand> {
        return commands
    }
}