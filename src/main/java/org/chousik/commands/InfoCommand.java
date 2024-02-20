package org.chousik.commands;

import org.chousik.exception.ArgumentCountError;
import org.chousik.handlers.ICollectionController;

/**
 * Команда info. Позволяет увидеть информацию о коллекции.
 */
public class InfoCommand extends ACommand {
    private ICollectionController collectionController;

    public InfoCommand(ICollectionController collectionController) {
        super("info", "команда позволяет увидеть информацию о коллекции.", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для вывода информации о коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        valideCountsArgument(args);
        System.out.println("Тип коллекции: " + collectionController.getCollectionType());
        System.out.println("Кол-во элементов: " + collectionController.size());
        System.out.println("Дата последней инициализации: " + collectionController.getLastInitTime());
    }
}
