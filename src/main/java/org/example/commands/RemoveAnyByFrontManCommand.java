package org.example.commands;

import org.example.collection.Person;
import org.example.collection.builder.BuilderPerson;
import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class RemoveAnyByFrontManCommand extends AbstractCommand{
    ICollectionController collectionHandler;
    public RemoveAnyByFrontManCommand(ICollectionController CH){
        super("remove_any_by_front_man", "С помощью этой команды вы можете удалить группы с введеным лидером.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        Person person = new BuilderPerson().build();
        collectionHandler.removeByFrontMan(person);
        if (!RunHandler.mode()){System.out.println("Элемент успешно удален");}
    }
}
