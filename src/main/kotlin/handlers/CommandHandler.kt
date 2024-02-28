package org.chousik.handlers

import org.chousik.commands.ACommand

class CommandHandler {
    private val commands: HashMap<String, ACommand> = HashMap<String, ACommand>()

    fun addCommand(commandName: String, Command: ACommand) {
        commands[commandName] = Command
    }

    fun getCommands(): HashMap<String, ACommand> {
        return commands
    }
}