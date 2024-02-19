package org.example.handlers;

import org.example.commands.AbstractCommand;
import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.InvalidСommand;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.validators.ScriptValidor;

import java.util.Arrays;
import java.util.Scanner;

public class RunHandler {
    private CollectionHandlerIntefrace CollectionM;
    private CommandHandler CommandM;
    private static Scanner MainScaner = new Scanner(System.in);
    private static boolean isScript = false;
    public RunHandler(CollectionHandlerIntefrace CollectionM, CommandHandler CommandM){
        this.CollectionM = CollectionM;
        this.CommandM = CommandM;
    }
    public static Scanner getMainScaner() {
        return MainScaner;
    }

    public static void setMainScaner(Scanner mainScaner) {
        MainScaner = mainScaner;
    }
    public static void SetScriptMode(){
        isScript = true;
    }
    public static void SetUserMode(){
        isScript = false;
    }
    public static boolean Mode(){
        return isScript;
    }

    public void ConsoleRun(){
        while (true){
       try {
               String Messages = MainScaner.nextLine();
               RunCommand(Messages);
       }catch (InvalidСommand | InvalidCountArgument | ScriptRunErorr| IncorrectArguments e){
           System.out.println(e.toString());
       }
       catch (Exception e){
           System.out.println(e.toString());
           System.out.println("Бочек потик");
           System.exit(1488);
       }
    }}
    public void ScriptsRun() throws ScriptRunErorr{
        new ScriptValidor().valid();
    }
    public void RunCommand(String UserMessges) throws InvalidСommand, InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        String[] Messages = UserMessges.split("\\s+");
        String CommandString = Messages[0];
        String[] Argument = (Messages.length > 1)? Arrays.copyOfRange(Messages, 1, Messages.length) : new String[]{};
        AbstractCommand Command = CommandM.getCommands().get(CommandString);
        if (Command == null){
            throw new InvalidСommand(CommandString);
        }
        Command.execute(Argument);
    }
}

