package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;

public abstract class AbstractCommand {
    private String name;
    private String info;

    public AbstractCommand(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public abstract void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments;

    @Override
    public String toString() {
        return this.name + ": " + this.info;
    }
}

