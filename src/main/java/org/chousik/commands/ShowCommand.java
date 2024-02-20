package org.chousik.commands;

import org.chousik.exception.ArgumentCountError;
import org.chousik.handlers.ICollectionController;

/**
 * Команда show. Позволяет вывести коллекцию.
 */
public class ShowCommand extends ACommand {
    private ICollectionController collectionController;

    public ShowCommand(ICollectionController collectionController) {
        super("show", " команда позволяет вывести коллекцию.", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для вывода коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        valideCountsArgument(args);
        System.out.println(collectionController.getElements());
    }
}
