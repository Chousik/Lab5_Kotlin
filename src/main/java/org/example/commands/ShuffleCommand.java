package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;
/**
 * Команда shuffle. Позволяет перемешать элементы коллекции.
 */
public class ShuffleCommand extends ACommand {
    private ICollectionController collectionController;
    public ShuffleCommand(ICollectionController collectionController){
        super("shuffle", "команда позволяет перемешать элементы коллекции", 0);
        this.collectionController = collectionController;
    }
    /**
     * Метод для перемешивания элементов коллекции
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        valideCountsArgument(args);
        collectionController.shuffle();
        if (!RunHandler.mode()){System.out.println("Коллекция успешно перемешана");}
    }
}
