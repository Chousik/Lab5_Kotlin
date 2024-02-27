package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController

/**
 * Команда show. Позволяет вывести коллекцию.
 */
class ShowCommand(private val collectionController: ICollectionController<*>) :
    ACommand("show", " команда позволяет вывести коллекцию.", 0) {
    /**
     * Метод для вывода коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Throws(ArgumentCountError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        println(collectionController.elements)
    }
}