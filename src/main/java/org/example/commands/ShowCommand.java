package org.example.commands;

import org.example.exception.InvalidCountArgument;
import org.example.handlers.CollectionHandlerIntefrace;

public class ShowCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionH;
    public ShowCommand(CollectionHandlerIntefrace CH){
        super("show", " команда позволяет вывести коллекцию.");
        this.CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        System.out.println(CollectionH.getElements());
    }
}
