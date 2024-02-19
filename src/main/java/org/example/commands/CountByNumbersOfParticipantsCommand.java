package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;

public class CountByNumbersOfParticipantsCommand extends AbstractCommand{
    private ICollectionController collectionHandler;
    public CountByNumbersOfParticipantsCommand(ICollectionController CH){
        super("count_by_number_of_participants", "Команда позволяет вывести количество элементов, с кол-вом участников равному введеному.");
        this.collectionHandler = CH;
    }

    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        if (args.length!=1) {throw new ArgumentCountError(1,args.length);}
        try {
            Long numbers = Long.parseLong(args[0]);
            System.out.println("Кол-во групп: " + collectionHandler.countNumberOfParticipants(numbers));
        } catch (NumberFormatException e){
            throw new ArgumentError("Айди должно быть числом");
        }
    }
}
