package org.chousik.commands;

import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.RunHandler;

/**
 * Команда remove_by_id. Позволяет удалить элемент с введеным id.
 */
public class RemoveByIdCommand extends ACommand {
    private ICollectionController collectionController;

    public RemoveByIdCommand(ICollectionController collectionController) {
        super("remove_by_id {id} ", "команда позволяет удалить элемент с введеным id", 1);
        this.collectionController = collectionController;
    }

    /**
     * Метод для удаления элемента с введеным id
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
            Integer id = Integer.parseInt(args[0]);
            collectionController.removeElementByID(id);
        } catch (NumberFormatException e) {
            throw new ArgumentError("Айди должно быть числом");
        }
        if (!RunHandler.mode()) {
            System.out.println("Элемент успешно удален");
        }
    }
}
