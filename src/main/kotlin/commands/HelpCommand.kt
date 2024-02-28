package org.chousik.commands

import org.chousik.handlers.CommandHandler


class HelpCommand(private val commandHandler: CommandHandler) :
    ACommand("help", "команда позволяет получить список доступных команд.", 0) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        println("Доступные команды:")
        for (aCommand in commandHandler.getCommands().values) {
            println(aCommand.toString())
        }
    }
}