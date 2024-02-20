package org.chousik.commands;

import org.chousik.exception.ArgumentCountError;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.RunHandler;

/**
 * Команда shuffle. Позволяет перемешать элементы коллекции.
 */
public class ShuffleCommand extends ACommand {
    private ICollectionController collectionController;

    public ShuffleCommand(ICollectionController collectionController) {
        super("shuffle", "команда позволяет перемешать элементы коллекции", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для перемешивания элементов коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        valideCountsArgument(args);
        collectionController.shuffle();
        if (!RunHandler.mode()) {
            System.out.println("Коллекция успешно перемешана");
        }
    }
}
