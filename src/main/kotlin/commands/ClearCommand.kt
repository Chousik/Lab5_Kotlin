package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда clear. Позволяет очистить коллекцию.
 */
class ClearCommand(private val collectionController: ICollectionController<*>) :
    ACommand("clear", "команда позволяет очистить коллекцию.", 0) {
    /**
     * Метод для очистки коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        collectionController.clear()
        if (!RunHandler.mode()) {
            println("Коллекция успешно очищена")
        }
    }
}