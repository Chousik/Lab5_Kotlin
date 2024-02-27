package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда reorder. Позволяет отсортировать коллекцию в обратном порядке.
 */
class ReorderCommand(private val collectionController: ICollectionController<*>) :
    ACommand("reorder", "команда позволяет отсортирова коллекцию в обратном порядке.", 0) {
    /**
     * Метод для отсортировки коллекции в обратном порядке
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Throws(ArgumentCountError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        collectionController.reorder()
        if (!RunHandler.mode()) {
            println("Коллекция успешно реверснута")
        }
    }
}