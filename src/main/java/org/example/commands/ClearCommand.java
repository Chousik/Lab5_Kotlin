package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class ClearCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public ClearCommand(ICollectionController CH) {
        super("clear", "команда позволяет очистить коллекцию.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        collectionHandler.clear();
        if (!RunHandler.mode()){System.out.println("Коллекция успешно очищена");}
    }
}
