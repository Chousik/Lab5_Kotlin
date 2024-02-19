package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.ICollectionController;

public class ShowCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public ShowCommand(ICollectionController CH){
        super("show", " команда позволяет вывести коллекцию.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        System.out.println(collectionHandler.getElements());
    }
}
