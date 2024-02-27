package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда update. Позволяет обновить элемент с введеным айди
 */
class UpdateCommand(private val collectionController: ICollectionController<*>) :
    ACommand("update", "команда позволяет обновить элемент с введеным айди", 1) {
    /**
     * Метод для обновления элемента с введеным айди
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Throws(ArgumentCountError::class, ArgumentError::class, ScriptExecutionError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        try {
            val id = args[0]!!.toInt()
            collectionController.updateElements(id)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно обновлен")
        }
    }
}