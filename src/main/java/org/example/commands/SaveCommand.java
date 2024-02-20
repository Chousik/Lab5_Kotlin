package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
/**
 * Команда save. Позволяет сохранить данные в файл
 */
public class SaveCommand extends ACommand {
    private ICollectionController collectionController;
    public SaveCommand(ICollectionController collectionController){
        super("save", "команда позволяет сохранить данные в файл", 0);
        this.collectionController = collectionController;
    }
    /**
     * Метод для сохранения данных в файл
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        collectionController.saveData();
    }
}
