package org.example.handlers;

import org.example.commands.ACommand;
import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.InvalidCommandError;
import org.example.exception.ScriptExecutionError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RunHandler {
    private ICollectionController CollectionM;
    private CommandHandler commandHandler;
    private static Scanner mainScaner = new Scanner(System.in);
    private static boolean isScript = false;

    public RunHandler(ICollectionController CollectionM, CommandHandler CommandM) {
        this.CollectionM = CollectionM;
        this.commandHandler = CommandM;
    }

    public static Scanner getMainScaner() {
        return mainScaner;
    }

    public static boolean mode() {
        return isScript;
    }

    /**
     * Метод для запуска прогрммы в режиме консольной работы
     */

    public void consoleRun() {
        while (true) {
            try {
                String Messages = mainScaner.nextLine();
                runCommand(Messages);
            } catch (InvalidCommandError | ArgumentCountError | ScriptExecutionError | ArgumentError e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Бочек потик");
                System.exit(1488);
            }
        }
    }

    /**
     * Метод для запуска программы в режиме скрипта
     *
     * @param fileName имя файла
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     */
    public void scriptsRun(String fileName) throws ScriptExecutionError {
        Scanner lastScraner = getMainScaner();
        isScript = true;
        try {
            mainScaner = new Scanner(new File(fileName));
            while (mainScaner.hasNext()) {
                String messages = mainScaner.nextLine();
                runCommand(messages);
            }
        } catch (InvalidCommandError | ArgumentCountError | ArgumentError e) {
            throw new ScriptExecutionError(e.toString());
        } catch (FileNotFoundException e) {
        } finally {
            mainScaner = lastScraner;
            isScript = false;
        }
    }

    /**
     * Метод для поиска и выполнения команды
     *
     * @param userMessges сообщение пользователя
     * @throws InvalidCommandError  если команда неверная
     * @throws ArgumentCountError   если неверное количество аргументов
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     * @throws ArgumentError        если аргумент неверный
     */
    public void runCommand(String userMessges) throws InvalidCommandError, ArgumentCountError, ScriptExecutionError, ArgumentError {
        String[] messages = userMessges.split("\\s+");
        String commandString = messages[0];
        String[] argument = (messages.length > 1) ? Arrays.copyOfRange(messages, 1, messages.length) : new String[]{};
        ACommand command = commandHandler.getCommands().get(commandString);
        if (command == null) {
            throw new InvalidCommandError(commandString);
        }
        command.execute(argument);
    }
}

