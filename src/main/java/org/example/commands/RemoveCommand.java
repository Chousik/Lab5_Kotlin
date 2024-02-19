package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class RemoveCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CommandH;
    public RemoveCommand(CollectionHandlerIntefrace CH){
        super("remove_by_id {id} ","команда позволяет удалить элемент с введеным id");
        CommandH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=1) {throw new InvalidCountArgument(1,args.length);}
        try {
            Integer id = Integer.parseInt(args[0]);
            CommandH.RemoveElementByID(id);
        } catch (NumberFormatException e) {
            throw new IncorrectArguments("Айди должно быть числом");
        }
        if (!RunHandler.Mode()){System.out.println("Элемент успешно удален");}
    }
}
