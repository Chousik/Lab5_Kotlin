package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class RemoveByIdCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public RemoveByIdCommand(ICollectionController CH){
        super("remove_by_id {id} ","команда позволяет удалить элемент с введеным id");
        collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        if (args.length!=1) {throw new ArgumentCountError(1,args.length);}
        try {
            Integer id = Integer.parseInt(args[0]);
            collectionHandler.removeElementByID(id);
        } catch (NumberFormatException e) {
            throw new ArgumentError("Айди должно быть числом");
        }
        if (!RunHandler.mode()){System.out.println("Элемент успешно удален");}
    }
}
