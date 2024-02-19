package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;

public class SaveCommand extends AbstractCommand {
    private ICollectionController collectionHandler;
    public SaveCommand(ICollectionController CH){
        super("save", "команда позволяет сохранить данные в файл");
        collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        collectionHandler.saveData();
    }
}
