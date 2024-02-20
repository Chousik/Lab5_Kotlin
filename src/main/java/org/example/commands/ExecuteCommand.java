package org.example.commands;

import org.example.commands.validators.ScriptRecursionValidor;
import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.io.FileNotFoundException;
/**
 * Команда execute. Позволяет выполнить указанный скрипт
 */
public class ExecuteCommand extends ACommand {
    RunHandler runHandler;
    public ExecuteCommand(RunHandler runHandler){
        super("execute {sctipt_file}", "команда позволяет выполнить указанный скрипт", 1);
        this.runHandler = runHandler;
    }
    /**
     * Метод для выполнения скрипта
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError{
        valideCountsArgument(args);
        new ScriptRecursionValidor().valid(args[0]);
        runHandler.scriptsRun(args[0]);
    }
}
