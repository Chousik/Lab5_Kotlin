package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;

import java.util.Collection;

public class FilterAlbumsCountCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionH;
    public FilterAlbumsCountCommand(CollectionHandlerIntefrace CH){
        super("filter_by_albums_count", "Вывести группы с введеным числом альбомов");
        this.CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=1) {throw new InvalidCountArgument(1,args.length);}
        try {
            Integer integer = Integer.parseInt(args[0]);
            System.out.println(CollectionH.getElementsByAlbomCount(integer));
        } catch (NumberFormatException e){
            throw new IncorrectArguments("Кол-во групп должно быть числом");
        }
    }
}
