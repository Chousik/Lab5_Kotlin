package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;

import java.io.FileNotFoundException;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(){
        super("exit", "Команда завершает работу программы");
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError, FileNotFoundException {
        System.exit(0);
    }
}
