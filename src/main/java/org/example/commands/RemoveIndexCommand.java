package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class RemoveIndexCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CommandH;
    public RemoveIndexCommand(CollectionHandlerIntefrace CH){
        super("remove_at {index} ","команда позволяет удалить элемент с введеным индексом.");
        CommandH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=1) {throw new InvalidCountArgument(1,args.length);}
        try {
            Integer index = Integer.parseInt(args[0]);
            CommandH.RemoveElements(index);
        } catch (NumberFormatException e){
            throw new IncorrectArguments("Айди должно быть числом");
        }
        if (!RunHandler.Mode()){System.out.println("Элемент успешно удален");}
    }
}
