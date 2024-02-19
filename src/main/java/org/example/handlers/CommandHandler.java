package org.example.handlers;

import org.example.commands.AbstractCommand;

import java.util.HashMap;

public class CommandHandler {
    private HashMap<String, AbstractCommand> Commands = new HashMap<>();
    public void AddCommand(String commandName, AbstractCommand Command){
        Commands.put(commandName, Command);
    }

    public HashMap<String, AbstractCommand> getCommands() {
        return Commands;
    }
}
