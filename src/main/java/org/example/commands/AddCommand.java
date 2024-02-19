package org.example.commands;

import org.example.collection.MusicBand;
import org.example.collection.builder.BuilderMusicBand;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.RunHandler;

public class AddCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionHandler;
    public AddCommand(CollectionHandlerIntefrace CH) {
        super("add", "команда позволяет добавить новый элемент.");
        this.CollectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        MusicBand musicBand = new BuilderMusicBand().build();
        CollectionHandler.add(musicBand);
        if (!RunHandler.Mode()){System.out.println("Элемент успешно добавлен");}
    }


}
