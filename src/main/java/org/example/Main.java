package org.example;

import org.example.commands.*;
import org.example.database.IDataBase;
import org.example.database.JsonDB;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.CollectionControllerPerson;
import org.example.handlers.CommandHandler;
import org.example.handlers.RunHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ScriptExecutionError, IOException {
        run(args);
    }
    public static void run(String[] args) throws IOException {
        IDataBase jsonDB = new JsonDB("Data.json");
        ICollectionController CM = new CollectionControllerPerson(jsonDB);
        CM.loadData();
        CommandHandler ComM = new CommandHandler();
        ComM.AddCommand("add", new AddCommand(CM));
        ComM.AddCommand("help", new HelpCommand(ComM));
        ComM.AddCommand("info", new InfoCommand(CM));
        ComM.AddCommand("show", new ShowCommand(CM));
        ComM.AddCommand("update", new UpdateCommand(CM));
        ComM.AddCommand("remove_by_id", new RemoveByIdCommand(CM));
        ComM.AddCommand("clear", new ClearCommand(CM));
        ComM.AddCommand("remove_at", new RemoveAtCommand(CM));
        ComM.AddCommand("shuffle", new ShuffleCommand(CM));
        ComM.AddCommand("reorder", new ReorderCommand(CM));
        ComM.AddCommand("remove_any_by_front_man", new RemoveAnyByFrontManCommand(CM));
        ComM.AddCommand("count_by_number_of_participants", new CountByNumbersOfParticipantsCommand(CM));
        ComM.AddCommand("filter_by_albums_count", new FilterByAlbumsCountCommand(CM));
        ComM.AddCommand("save", new SaveCommand(CM));
        ComM.AddCommand("exit", new ExitCommand());
        RunHandler RUNMAIN = new RunHandler(CM, ComM);
        ComM.AddCommand("execute", new ExecuteCommand(RUNMAIN));
        RUNMAIN.consoleRun();
    }
}