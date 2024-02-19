package org.example.commands;

import org.example.collection.Person;
import org.example.collection.builder.BuilderPerson;
import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class RemoveByFrontMan extends AbstractCommand{
    CollectionHandlerIntefrace CollectionH;
    public RemoveByFrontMan(CollectionHandlerIntefrace CH){
        super("remove_any_by_front_man", "С помощью этой команды вы можете удалить группы с введеным лидером.");
        this.CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        Person person = new BuilderPerson().build();
        CollectionH.RemoveByFrontMan(person);
        if (!RunHandler.Mode()){System.out.println("Элемент успешно удален");}
    }
}
