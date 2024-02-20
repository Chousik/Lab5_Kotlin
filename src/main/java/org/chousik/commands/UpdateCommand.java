package org.chousik.commands;

import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.RunHandler;

/**
 * Команда update. Позволяет обновить элемент с введеным айди
 */
public class UpdateCommand extends ACommand {
    private ICollectionController collectionController;

    public UpdateCommand(ICollectionController collectionController) {
        super("update", "команда позволяет обновить элемент с введеным айди", 1);
        this.collectionController = collectionController;
    }

    /**
     * Метод для обновления элемента с введеным айди
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ArgumentError, ScriptExecutionError {
        valideCountsArgument(args);
        try {
            Integer id = Integer.parseInt(args[0]);
            collectionController.updateElements(id);
        } catch (NumberFormatException e) {
            throw new ArgumentError("Айди должно быть числом");
        }
        if (!RunHandler.mode()) {
            System.out.println("Элемент успешно обновлен");
        }
    }
}
