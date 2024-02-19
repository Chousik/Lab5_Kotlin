package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class ShuffleCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionH;
    public ShuffleCommand(CollectionHandlerIntefrace CH){
        super("shuffle", "команда позволяет перемешать элементы коллекции");
        CollectionH = CH;
    }
    @Override
    public void execute(String[] args) throws InvalidCountArgument {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        CollectionH.Shuffle();
        if (!RunHandler.Mode()){System.out.println("Коллекция успешно перемешана");}
    }
}
