package commands

import org.chousik.handlers.CommandHandler


class HelpCommand(private val commandMap: Map<String, ACommand>) :
    ACommand("help", "команда позволяет получить список доступных команд.", 0) {

    override fun execute(args: Array<String>) {}
}