package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда remove_by_id. Позволяет удалить элемент с введеным id.
 */
class RemoveByIdCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_by_id {id} ", "команда позволяет удалить элемент с введеным id", 1) {
    /**
     * Метод для удаления элемента с введеным id
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        try {
            val id = args[0]!!.toInt()
            collectionController.removeElementByID(id)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}