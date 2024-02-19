package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.CommandHandler;

public class HelpCommand extends AbstractCommand{
    private CommandHandler commandHandler;
    public HelpCommand(CommandHandler CH){
        super("help", "команда позволяет получить список доступных команд.");
        this.commandHandler = CH;
    }

    @Override
    public void execute(String[] args)  throws ArgumentCountError {
        if (args.length!=0) {throw new ArgumentCountError(0,args.length);}
        System.out.println("Доступные команды:");
        for (AbstractCommand Command : commandHandler.getCommands().values()){
            System.out.println(Command.toString());
        }
    }
}
