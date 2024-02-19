package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;

public class FilterByAlbumsCountCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public FilterByAlbumsCountCommand(ICollectionController CH){
        super("filter_by_albums_count", "Вывести группы с введеным числом альбомов");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        if (args.length!=1) {throw new ArgumentCountError(1,args.length);}
        try {
            Integer integer = Integer.parseInt(args[0]);
            System.out.println(collectionHandler.getElementsByAlbomCount(integer));
        } catch (NumberFormatException e){
            throw new ArgumentError("Кол-во групп должно быть числом");
        }
    }
}
