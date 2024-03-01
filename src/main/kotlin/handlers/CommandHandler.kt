package org.chousik.handlers

import org.chousik.commands.ACommand

class CommandHandler(private val commands: HashMap<String, ACommand>) {

    fun addCommand(commandName: String, aCommand: ACommand) {
        commands[commandName] = aCommand
    }

    fun getCommands(): HashMap<String, ACommand> {
        return commands
    }
}