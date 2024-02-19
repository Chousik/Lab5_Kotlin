package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class ShuffleCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public ShuffleCommand(ICollectionController CH){
        super("shuffle", "команда позволяет перемешать элементы коллекции");
        collectionHandler = CH;
    }
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        collectionHandler.shuffle();
        if (!RunHandler.mode()){System.out.println("Коллекция успешно перемешана");}
    }
}
