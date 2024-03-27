package builders

import commands.ACommand
import CommandHandler
import commands.CommandType

class CommandHandlerBuilder(private val commands: HashMap<CommandType, ACommand> = HashMap()) {

    fun addCommand(commandType: CommandType, aCommand: ACommand): CommandHandlerBuilder {
        commands[commandType] = aCommand
        return this
    }

    fun build(): CommandHandler{
        return CommandHandler(this.commands)
    }
}