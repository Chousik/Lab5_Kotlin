package handlers.builders

import commands.ACommand
import handlers.CommandHandler

class CommandHandlerBuilder(private val commands: HashMap<String, ACommand> = HashMap()) {

    fun addCommands(commands: List<ACommand>): CommandHandlerBuilder {
        commands.stream().forEach{x -> addCommand(x)}
        return this
    }

    private fun addCommand(aCommand: ACommand): CommandHandlerBuilder {
        commands[aCommand.name] = aCommand
        return this
    }

    fun build(): CommandHandler{
        return CommandHandler(this.commands)
    }
}