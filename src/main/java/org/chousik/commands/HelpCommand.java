package org.chousik.commands;

import org.chousik.exception.ArgumentCountError;
import org.chousik.handlers.CommandHandler;

/**
 * Команда help. Позволяет получить список доступных команд.
 */
public class HelpCommand extends ACommand {
    private CommandHandler commandHandler;

    public HelpCommand(CommandHandler commandHandler) {
        super("help", "команда позволяет получить список доступных команд.", 0);
        this.commandHandler = commandHandler;
    }

    /**
     * Метод для получения списка доступных команд
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        valideCountsArgument(args);
        System.out.println("Доступные команды:");
        for (ACommand Command : commandHandler.getCommands().values()) {
            System.out.println(Command.toString());
        }
    }
}
