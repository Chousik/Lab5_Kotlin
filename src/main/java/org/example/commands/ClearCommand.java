package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class ClearCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionHandler;
    public ClearCommand(CollectionHandlerIntefrace CH) {
        super("clear", "команда позволяет очистить коллекцию.");
        this.CollectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        CollectionHandler.Clear();
        if (!RunHandler.Mode()){System.out.println("Коллекция успешно очищена");}
    }
}
