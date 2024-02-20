package org.example.handlers;

import org.example.commands.ACommand;

import java.util.HashMap;

/**
 * Класс управления списком команд
 */
public class CommandHandler {
    private HashMap<String, ACommand> commands = new HashMap<>();

    /**
     * Добавление команды в список
     *
     * @param commandName - имя команды
     * @param Command     - команда
     */
    public void AddCommand(String commandName, ACommand Command) {
        commands.put(commandName, Command);
    }

    /**
     * Получение списка команд
     *
     * @return список команд
     */
    public HashMap<String, ACommand> getCommands() {
        return commands;
    }
}
