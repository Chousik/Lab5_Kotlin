package org.example.commands;

import org.example.exception.IncorrectArguments;
import org.example.exception.InvalidCountArgument;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.CollectionHandlerIntefrace;

public class CountByNumbersParticipantsCommand extends AbstractCommand{
    private CollectionHandlerIntefrace CollectionH;
    public CountByNumbersParticipantsCommand(CollectionHandlerIntefrace CH){
        super("count_by_number_of_participants", "Команда позволяет вывести количество элементов, с кол-вом участников равному введеному.");
        this.CollectionH = CH;
    }

    @Override
    public void execute(String[] args) throws InvalidCountArgument, ScriptRunErorr, IncorrectArguments {
        if (args.length!=1) {throw new InvalidCountArgument(1,args.length);}
        try {
            Long numbers = Long.parseLong(args[0]);
            System.out.println("Кол-во групп: " + CollectionH.CountNumberOfParticipants(numbers));
        } catch (NumberFormatException e){
            throw new IncorrectArguments("Айди должно быть числом");
        }
    }
}
