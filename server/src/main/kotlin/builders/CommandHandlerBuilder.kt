package builders

import CommandMatcher
import commands.ACommand
import commands.CommandType

class CommandHandlerBuilder(private var commands: Map<CommandType, ACommand>) {
    fun addCommand(
        commandType: CommandType,
        aCommand: ACommand,
    ): CommandHandlerBuilder {
        commands += mapOf(commandType to aCommand)
        return this
    }

    fun build(): CommandMatcher {
        return CommandMatcher(this.commands)
    }
}
