package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.CommandHandler

/**
 * Команда help. Позволяет получить список доступных команд.
 */
class HelpCommand(private val commandHandler: CommandHandler) :
    ACommand("help", "команда позволяет получить список доступных команд.", 0) {
    /**
     * Метод для получения списка доступных команд
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Throws(ArgumentCountError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        println("Доступные команды:")
        for (Command in commandHandler.getCommands().values) {
            println(Command.toString())
        }
    }
}