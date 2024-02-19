package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class ReorderCommand extends AbstractCommand {
    private ICollectionController collectionHandler;
    public ReorderCommand(ICollectionController CH){
        super("reorder", "Метод позволяет отсортирова коллекцию в обратном порядке.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        collectionHandler.reorder();
        if (!RunHandler.mode()){System.out.println("Коллекция успешно реверснута");}
    }
}
