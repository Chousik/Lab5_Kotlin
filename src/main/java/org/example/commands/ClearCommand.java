package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

/**
 * Команда clear. Позволяет очистить коллекцию.
 */
public class ClearCommand extends ACommand {
    private ICollectionController collectionController;

    public ClearCommand(ICollectionController collectionController) {
        super("clear", "команда позволяет очистить коллекцию.", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для очистки коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        collectionController.clear();
        if (!RunHandler.mode()) {
            System.out.println("Коллекция успешно очищена");
        }
    }
}
