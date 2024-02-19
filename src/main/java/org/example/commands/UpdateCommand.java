package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class UpdateCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CommandH;
    public UpdateCommand(CollectionHandlerIntefrace CH){
        super("update", "команда позволяет обновить элемент с введеным айди");
        this.CommandH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, IncorrectArguments, ScriptRunErorr {
        if (args.length!=1) {throw new InvalidCountArgument(1,args.length);}
        try {
            Integer id = Integer.parseInt(args[0]);
            CommandH.updateElements(id);
        } catch (NumberFormatException e){
            throw new IncorrectArguments("Айди должно быть числом");
        }
        if (!RunHandler.Mode()){System.out.println("Элемент успешно обновлен");}
    }
}
