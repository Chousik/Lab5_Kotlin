package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.ICollectionController;

public class InfoCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public InfoCommand(ICollectionController CH){
        super("info", "команда позволяет увидеть информацию о коллекции.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        System.out.println("Тип коллекции: " + collectionHandler.getCollectionType());
        System.out.println("Кол-во элементов: " + collectionHandler.size());
        System.out.println("Дата последней инициализации: " + collectionHandler.getLastInitTime());
    }
}
