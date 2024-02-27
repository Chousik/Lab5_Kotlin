package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда shuffle. Позволяет перемешать элементы коллекции.
 */
class ShuffleCommand(private val collectionController: ICollectionController<*>) :
    ACommand("shuffle", "команда позволяет перемешать элементы коллекции", 0) {
    /**
     * Метод для перемешивания элементов коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Throws(ArgumentCountError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        collectionController.shuffle()
        if (!RunHandler.mode()) {
            println("Коллекция успешно перемешана")
        }
    }
}