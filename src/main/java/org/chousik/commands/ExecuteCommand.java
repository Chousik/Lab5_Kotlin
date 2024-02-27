package org.chousik.commands;

import org.chousik.commands.validators.ScriptFileValidator;
import org.chousik.commands.validators.ScriptRecursionValidor;
import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

/**
 * Команда execute. Позволяет выполнить указанный скрипт
 */
public class ExecuteCommand extends ACommand {
    RunHandler runHandler;

    public ExecuteCommand(RunHandler runHandler) {
        super("execute {sctipt_file}", "команда позволяет выполнить указанный скрипт", 1);
        this.runHandler = runHandler;
    }

    /**
     * Метод для выполнения скрипта
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        new ScriptFileValidator().valid(args[0]);
        new ScriptRecursionValidor().valid(args[0]);
        runHandler.scriptsRun(args[0]);
    }
}
