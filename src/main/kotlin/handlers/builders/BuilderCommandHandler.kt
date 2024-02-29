package handlers.builders

import org.chousik.commands.ACommand
import org.chousik.handlers.CommandHandler

class BuilderCommandHandler {

    fun build(commands: List<ACommand>): CommandHandler {
        val result = CommandHandler()
        for (command in commands) {
            result.addCommand(command.name, command)
        }
        return result
    }
}
