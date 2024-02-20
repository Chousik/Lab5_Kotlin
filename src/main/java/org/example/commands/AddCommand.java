package org.example.commands;

import org.example.collection.MusicBand;
import org.example.collection.builder.BuilderMusicBand;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.ICollectionController;
import org.example.handlers.RunHandler;

/**
 * Команда add. Позволяет добавить новый элемент в коллекцию.
 */
public class AddCommand extends ACommand {
    private ICollectionController collectionController;

    public AddCommand(ICollectionController collectionController) {
        super("add", "Команда позволяет добавить новый элемент.", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для добавления элемента в коллекцию
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError {
        valideCountsArgument(args);
        MusicBand musicBand = new BuilderMusicBand().build();
        collectionController.add(musicBand);
        if (!RunHandler.mode()) {
            System.out.println("Элемент успешно добавлен");
        }
    }
}
