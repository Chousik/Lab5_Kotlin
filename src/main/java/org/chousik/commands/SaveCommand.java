package org.chousik.commands;

import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.RunHandler;

/**
 * Команда save. Позволяет сохранить данные в файл
 */
public class SaveCommand extends ACommand {
    private ICollectionController collectionController;

    public SaveCommand(ICollectionController collectionController) {
        super("save", "команда позволяет сохранить данные в файл", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для сохранения данных в файл
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        if (!RunHandler.mode() & collectionController.saveData()) {
            System.out.println("Данные успешно сохранены");
        }
    }
}
