package org.example.commands;

import org.example.exception.InvalidCountArgument;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class ReorderCommand extends AbstractCommand {
    private CollectionHandlerIntefrace CollectionH;
    public ReorderCommand(CollectionHandlerIntefrace CH){
        super("reorder", "Метод позволяет отсортирова коллекцию в обратном порядке.");
        this.CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument{
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        CollectionH.Reorder();
        if (!RunHandler.Mode()){System.out.println("Коллекция успешно реверснута");}
    }
}
