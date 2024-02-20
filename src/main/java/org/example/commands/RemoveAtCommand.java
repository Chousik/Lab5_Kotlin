package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;
/**
 * Команда remove_at. Позволяет удалить элемент с введеным индексом.
 */
public class RemoveAtCommand extends ACommand {
    private ICollectionController collectionController;
    public RemoveAtCommand(ICollectionController collectionController){
        super("remove_at {index} ","команда позволяет удалить элемент с введеным индексом.", 1);
        this.collectionController = collectionController;
    }
    /**
     * Метод для удаления элемента с введеным индексом
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        try {
            Integer index = Integer.parseInt(args[0]);
            collectionController.removeElements(index);
        } catch (NumberFormatException e){
            throw new ArgumentError("Айди должно быть числом");
        }
        if (!RunHandler.mode()){System.out.println("Элемент успешно удален");}
    }
}
