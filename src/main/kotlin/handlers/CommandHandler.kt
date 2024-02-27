package org.chousik.handlers

import org.chousik.commands.ACommand

/**
 * Класс управления списком команд
 */
class CommandHandler {
    private val commands: HashMap<String, ACommand> = HashMap<String, ACommand>()

    /**
     * Добавление команды в список
     *
     * @param commandName - имя команды
     * @param Command     - команда
     */
    fun addCommand(commandName: String, Command: ACommand) {
        commands[commandName] = Command
    }

    /**
     * Получение списка команд
     *
     * @return список команд
     */
    fun getCommands(): HashMap<String, ACommand> {
        return commands
    }
}