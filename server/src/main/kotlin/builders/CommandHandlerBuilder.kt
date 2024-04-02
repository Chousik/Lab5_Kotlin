package builders

import commands.ACommand
import CommandHandler
import commands.CommandType

class CommandHandlerBuilder(private var commands: Map<CommandType, ACommand>) {

    fun addCommand(commandType: CommandType, aCommand: ACommand): CommandHandlerBuilder {
        commands+= mapOf(commandType to aCommand)
        return this
    }

    fun build(): CommandHandler{
        return CommandHandler(this.commands)
    }
}