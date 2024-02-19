package org.example.handlers;

import org.example.commands.AbstractCommand;
import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.InvalidCommandError;
import org.example.exception.ScriptExecutionError;
import org.example.commands.validators.ScriptValidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RunHandler {
    private ICollectionController CollectionM;
    private CommandHandler commandHandler;
    private static Scanner mainScaner = new Scanner(System.in);
    private static boolean isScript = false;
    public RunHandler(ICollectionController CollectionM, CommandHandler CommandM){
        this.CollectionM = CollectionM;
        this.commandHandler = CommandM;
    }
    public static Scanner getMainScaner() {
        return mainScaner;
    }
    public static boolean mode(){
        return isScript;
    }

    public void consoleRun(){
        while (true){
       try {
               String Messages = mainScaner.nextLine();
               runCommand(Messages);
       }catch (InvalidCommandError | ArgumentCountError | ScriptExecutionError | ArgumentError e){
           System.out.println(e);
       }
       catch (Exception e){
           System.out.println(e);
           System.out.println("Бочек потик");
           System.exit(1488);
       }
    }}
    public void scriptsRun(String fileName) throws ScriptExecutionError, FileNotFoundException {
        Scanner lastScraner = getMainScaner();
        isScript = true;
        try {
            mainScaner = new Scanner(new File(fileName));
            while (mainScaner.hasNext()){
                try {
                    String messages = mainScaner.nextLine();
                    runCommand(messages);
                }catch (InvalidCommandError | ArgumentCountError | ArgumentError e){
                    System.out.println(e);
                }}
        } catch (ScriptExecutionError e){
            System.out.println("Невалидный скрипт: " + e);
        } finally {
            mainScaner = lastScraner;
            isScript = false;
        }
    }
    public void runCommand(String userMessges) throws InvalidCommandError, ArgumentCountError, ScriptExecutionError, ArgumentError, FileNotFoundException {
        String[] messages = userMessges.split("\\s+");
        String commandString = messages[0];
        String[] argument = (messages.length > 1)? Arrays.copyOfRange(messages, 1, messages.length) : new String[]{};
        AbstractCommand command = commandHandler.getCommands().get(commandString);
        if (command == null){
            throw new InvalidCommandError(commandString);
        }
        command.execute(argument);
    }
}

