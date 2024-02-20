package org.chousik.commands;

import org.chousik.collection.Person;
import org.chousik.collection.builder.BuilderPerson;
import org.chousik.exception.ArgumentError;
import org.chousik.exception.ArgumentCountError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.ICollectionController;
import org.chousik.handlers.RunHandler;

/**
 * Команда remove_any_by_front. Позволяет удалить группы с введеным лидером.
 */
public class RemoveAnyByFrontManCommand extends ACommand {
    ICollectionController collectionController;

    public RemoveAnyByFrontManCommand(ICollectionController collectionController) {
        super("remove_any_by_front_man", "команда позволяет удалить группы с введеным лидером.", 0);
        this.collectionController = collectionController;
    }

    /**
     * Метод для удаления групп с введеным лидером
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Override
    public void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError {
        valideCountsArgument(args);
        Person person = new BuilderPerson().build();
        collectionController.removeByFrontMan(person);
        if (!RunHandler.mode()) {
            System.out.println("Элемент успешно удален");
        }
    }
}
