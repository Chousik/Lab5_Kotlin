package org.example;

import org.example.commands.*;
import org.example.database.InterfaceDataBase;
import org.example.database.JsonDB;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;
import org.example.handlers.CollectionHandlerPerson;
import org.example.handlers.CommandHandler;
import org.example.handlers.RunHandler;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ScriptRunErorr, IOException {
        run(args);
    }
    public static void run(String[] args) throws IOException {
        InterfaceDataBase jsonDB = new JsonDB("Data.json");
        CollectionHandlerIntefrace CM = new CollectionHandlerPerson(jsonDB);
        CM.LoadData();
        CommandHandler ComM = new CommandHandler();
        ComM.AddCommand("add", new AddCommand(CM));
        ComM.AddCommand("help", new HelpCommand(ComM));
        ComM.AddCommand("info", new InfoCommand(CM));
        ComM.AddCommand("show", new ShowCommand(CM));
        ComM.AddCommand("update", new UpdateCommand(CM));
        ComM.AddCommand("remove_by_id", new RemoveCommand(CM));
        ComM.AddCommand("clear", new ClearCommand(CM));
        ComM.AddCommand("remove_at", new RemoveIndexCommand(CM));
        ComM.AddCommand("shuffle", new ShuffleCommand(CM));
        ComM.AddCommand("reorder", new ReorderCommand(CM));
        ComM.AddCommand("remove_any_by_front_man", new RemoveByFrontMan(CM));
        ComM.AddCommand("count_by_number_of_participants", new CountByNumbersParticipantsCommand(CM));
        ComM.AddCommand("filter_by_albums_count", new FilterAlbumsCountCommand(CM));
        ComM.AddCommand("save", new SaveCommand(CM));
        RunHandler RUNMAIN = new RunHandler(CM, ComM);
        RUNMAIN.ConsoleRun();
    }
}