package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;

/**
 * Команда count_by_number_of_participants. Позволяет вывести количество элементов, с кол-вом участников равному введеному.
 */
public class CountByNumbersOfParticipantsCommand extends ACommand {
    private ICollectionController collectionController;

    public CountByNumbersOfParticipantsCommand(ICollectionController collectionController) {
        super("count_by_number_of_participants", "команда позволяет вывести количество элементов, с кол-вом участников равному введеному.", 1);
        this.collectionController = collectionController;
    }

    /**
     * Метод для вывода количества элементов, с кол-вом участников равному введеному.
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        try {
            Long numbers = Long.parseLong(args[0]);
            System.out.println("Кол-во групп: " + collectionController.countNumberOfParticipants(numbers));
        } catch (NumberFormatException e) {
            throw new ArgumentError("Айди должно быть числом");
        }
    }
}
