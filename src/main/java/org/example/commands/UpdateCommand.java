package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class UpdateCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public UpdateCommand(ICollectionController CH){
        super("update", "команда позволяет обновить элемент с введеным айди");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ArgumentError, ScriptExecutionError {
        if (args.length!=1) {throw new ArgumentCountError(1,args.length);}
        try {
            Integer id = Integer.parseInt(args[0]);
            collectionHandler.updateElements(id);
        } catch (NumberFormatException e){
            throw new ArgumentError("Айди должно быть числом");
        }
        if (!RunHandler.mode()){System.out.println("Элемент успешно обновлен");}
    }
}
