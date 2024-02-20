package org.chousik.commands;

import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.RunHandler;

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
