package org.example.commands;

import org.example.collection.MusicBand;
import org.example.collection.builder.BuilderMusicBand;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

public class AddCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public AddCommand(ICollectionController CH) {
        super("add", "команда позволяет добавить новый элемент.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        MusicBand musicBand = new BuilderMusicBand().build();
        collectionHandler.add(musicBand);
        if (!RunHandler.mode()){System.out.println("Элемент успешно добавлен");}
    }
}
