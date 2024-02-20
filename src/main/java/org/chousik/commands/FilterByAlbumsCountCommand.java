package org.chousik.commands;

import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.ICollectionController;

/**
 * Команда filter_by_albums_count. Позволяет вывести группы с введеным числом альбомов
 */
public class FilterByAlbumsCountCommand extends ACommand {
    private ICollectionController collectionController;

    public FilterByAlbumsCountCommand(ICollectionController collectionController) {
        super("filter_by_albums_count", "команда позволяет вывести группы с введеным числом альбомов", 1);
        this.collectionController = collectionController;
    }

    /**
     * Метод для вывода групп с введеным числом альбомов
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
            Integer integer = Integer.parseInt(args[0]);
            System.out.println(collectionController.getElementsByAlbomCount(integer));
        } catch (NumberFormatException e) {
            throw new ArgumentError("Кол-во групп должно быть числом");
        }
    }
}
