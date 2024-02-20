package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;

import java.io.FileNotFoundException;
/**
 * Команда exit. Позволяет завершить работу программы
 */
public class ExitCommand extends ACommand {
    public ExitCommand(){
        super("exit", "команда завершает работу программы",0);
    }
    /**
     * Метод для завершения работы программы
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        System.exit(0);
    }
}
