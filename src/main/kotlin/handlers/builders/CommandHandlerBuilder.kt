package handlers.builders

import org.chousik.commands.ACommand
import org.chousik.handlers.CommandHandler

class BuilderCommandHandler(private val commands: HashMap<String, ACommand> = HashMap()) {

    fun addCommands(commands: List<ACommand>): BuilderCommandHandler {
        for (command in commands) {
            this.add(command.name, command)
        }
        return this
    }
//    fun addCommand(command: ACommand): BuilderCommandHandler {
//        add(command.name, command)
//        return this
//    }
    private fun add(commandName: String, aCommand: ACommand) {
        commands[commandName] = aCommand
    }

    fun build(): CommandHandler{
        return CommandHandler(this.commands)
    }
}