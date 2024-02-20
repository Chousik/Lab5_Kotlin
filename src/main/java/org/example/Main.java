package org.example;

import org.example.commands.*;
import org.example.commands.validators.ScriptRecursionValidor;
import org.example.database.AltJsonDB;
import org.example.database.IDataBase;
import org.example.database.JsonDB;
import org.example.exception.ArgumentError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.CollectionControllerPerson;
import org.example.handlers.CommandHandler;
import org.example.handlers.RunHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ArgumentError {
        run("Database.json");
    }


































    public static void run(String fileName){
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("Введенного файла не существует, создан новый");
            try {
                file.createNewFile();
            }catch (Exception e){}
        }
        IDataBase jsonDB = new AltJsonDB(fileName);
        ICollectionController collectionControllerPerson = new CollectionControllerPerson(jsonDB);
        collectionControllerPerson.loadData();
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.AddCommand("add", new AddCommand(collectionControllerPerson));
        commandHandler.AddCommand("help", new HelpCommand(commandHandler));
        commandHandler.AddCommand("info", new InfoCommand(collectionControllerPerson));
        commandHandler.AddCommand("show", new ShowCommand(collectionControllerPerson));
        commandHandler.AddCommand("update", new UpdateCommand(collectionControllerPerson));
        commandHandler.AddCommand("remove_by_id", new RemoveByIdCommand(collectionControllerPerson));
        commandHandler.AddCommand("clear", new ClearCommand(collectionControllerPerson));
        commandHandler.AddCommand("remove_at", new RemoveAtCommand(collectionControllerPerson));
        commandHandler.AddCommand("shuffle", new ShuffleCommand(collectionControllerPerson));
        commandHandler.AddCommand("reorder", new ReorderCommand(collectionControllerPerson));
        commandHandler.AddCommand("remove_any_by_front_man", new RemoveAnyByFrontManCommand(collectionControllerPerson));
        commandHandler.AddCommand("count_by_number_of_participants", new CountByNumbersOfParticipantsCommand(collectionControllerPerson));
        commandHandler.AddCommand("filter_by_albums_count", new FilterByAlbumsCountCommand(collectionControllerPerson));
        commandHandler.AddCommand("save", new SaveCommand(collectionControllerPerson));
        commandHandler.AddCommand("exit", new ExitCommand());
        RunHandler runHandlerMain = new RunHandler(collectionControllerPerson, commandHandler);
        commandHandler.AddCommand("execute", new ExecuteCommand(runHandlerMain));
        System.out.println("Начала работы! Для вывода списка комманд используйте help.");
        runHandlerMain.consoleRun();
    }
}