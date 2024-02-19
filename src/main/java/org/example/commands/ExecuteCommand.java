package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.io.File;
import java.io.FileNotFoundException;

public class ExecuteCommand extends AbstractCommand{
    RunHandler runHandler;
    public ExecuteCommand(RunHandler runHandler){
        super("execute {sctipt_file}", "Команда позволяет выполнить указанный скрипт");
        this.runHandler = runHandler;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError, FileNotFoundException {
        if (args.length!=1) {throw new ArgumentCountError(1,args.length);}
        if (!new File(args[0]).exists()){throw new ArgumentError("Неверное имя файла");}
        runHandler.scriptsRun(args[0]);
    }
}
