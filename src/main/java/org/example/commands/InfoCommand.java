package org.example.commands;

import org.example.exception.InvalidCountArgument;
import org.example.handlers.CollectionHandlerIntefrace;

public class InfoCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionH;
    public InfoCommand(CollectionHandlerIntefrace CH){
        super("info", "команда позволяет увидеть информацию о коллекции.");
        this.CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        System.out.println("Тип коллекции: " + CollectionH.getCollectionType());
        System.out.println("Кол-во элементов: " + CollectionH.size());
        System.out.println("Дата последней инициализации: " + CollectionH.getLastInitTime());
    }
}
