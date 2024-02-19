package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;

import java.io.FileNotFoundException;

public abstract class AbstractCommand {
    private String name;
    private String info;

    public AbstractCommand(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public abstract void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError, FileNotFoundException;

    @Override
    public String toString() {
        return this.name + ": " + this.info;
    }
}

