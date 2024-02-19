package org.example.commands;

import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CommandHandler;

public class HelpCommand extends AbstractCommand{
    private CommandHandler CommandH;
    public HelpCommand(CommandHandler CH){
        super("help", "команда позволяет получить список доступных команд.");
        this.CommandH = CH;
    }

    @Override
    public void execute(String[] args)  throws InvalidCountArgument {
        if (args.length!=0) {throw new InvalidCountArgument(0,args.length);}
        System.out.println("Доступные команды:");
        for (AbstractCommand Command : CommandH.getCommands().values()){
            System.out.println(Command.toString());
        }
    }
}
