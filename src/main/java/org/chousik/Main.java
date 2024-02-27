package org.chousik;

import org.chousik.collection.MusicBand;
import org.chousik.commands.*;
import org.chousik.database.AltJsonDB;
import org.chousik.database.IDataBase;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.CollectionControllerPerson;
import org.chousik.handlers.CommandHandler;
import org.chousik.handlers.RunHandler;

import java.io.File;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0){
            System.err.println("Вы не ввели имя файла");
            System.exit(0);
        }
        run(args[0]);
    }


































    public static void run(String fileName){
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("Введенного файла не существует, создан новый");
            try {
                file.createNewFile();
            }catch (Exception ignored){}
        }
        IDataBase<MusicBand> jsonDB = new AltJsonDB(fileName);
        ICollectionController<MusicBand> collectionControllerPerson = new CollectionControllerPerson(jsonDB, new LinkedList<MusicBand>());
        collectionControllerPerson.loadData();
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.addCommand("add", new AddCommand(collectionControllerPerson));
        commandHandler.addCommand("help", new HelpCommand(commandHandler));
        commandHandler.addCommand("info", new InfoCommand(collectionControllerPerson));
        commandHandler.addCommand("show", new ShowCommand(collectionControllerPerson));
        commandHandler.addCommand("update", new UpdateCommand(collectionControllerPerson));
        commandHandler.addCommand("remove_by_id", new RemoveByIdCommand(collectionControllerPerson));
        commandHandler.addCommand("clear", new ClearCommand(collectionControllerPerson));
        commandHandler.addCommand("remove_at", new RemoveAtCommand(collectionControllerPerson));
        commandHandler.addCommand("shuffle", new ShuffleCommand(collectionControllerPerson));
        commandHandler.addCommand("reorder", new ReorderCommand(collectionControllerPerson));
        commandHandler.addCommand("remove_any_by_front_man", new RemoveAnyByFrontManCommand(collectionControllerPerson));
        commandHandler.addCommand("count_by_number_of_participants", new CountByNumbersOfParticipantsCommand(collectionControllerPerson));
        commandHandler.addCommand("filter_by_albums_count", new FilterByAlbumsCountCommand(collectionControllerPerson));
        commandHandler.addCommand("save", new SaveCommand(collectionControllerPerson));
        commandHandler.addCommand("exit", new ExitCommand());
        RunHandler runHandlerMain = new RunHandler(collectionControllerPerson, commandHandler);
        commandHandler.addCommand("execute", new ExecuteCommand(runHandlerMain));
        System.out.println("Начала работы! Для вывода списка комманд используйте help.");
        runHandlerMain.consoleRun();
    }
}