package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.CollectionHandlerPerson;

public class SaveCommand extends AbstractCommand {
    private CollectionHandlerIntefrace CollectionH;
    public SaveCommand(CollectionHandlerIntefrace CH){
        super("save", "команда позволяет сохранить данные в файл");
        CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        CollectionH.SaveData();
    }
}
