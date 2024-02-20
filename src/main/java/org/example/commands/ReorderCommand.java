package org.example.commands;

import org.example.exception.ArgumentCountError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;
/**
 * Команда reorder. Позволяет отсортировать коллекцию в обратном порядке.
 */
public class ReorderCommand extends ACommand {
    private ICollectionController collectionController;
    public ReorderCommand(ICollectionController collectionController){
        super("reorder", "команда позволяет отсортирова коллекцию в обратном порядке.", 0);
        this.collectionController = collectionController;
    }
    /**
     * Метод для отсортировки коллекции в обратном порядке
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError {
        valideCountsArgument(args);
        collectionController.reorder();
        if (!RunHandler.mode()){System.out.println("Коллекция успешно реверснута");}
    }
}
