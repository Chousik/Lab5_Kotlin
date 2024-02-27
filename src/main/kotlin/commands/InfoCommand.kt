package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController

/**
 * Команда info. Позволяет увидеть информацию о коллекции.
 */
class InfoCommand(private val collectionController: ICollectionController<*>) :
    ACommand("info", "команда позволяет увидеть информацию о коллекции.", 0) {
    /**
     * Метод для вывода информации о коллекции
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Throws(ArgumentCountError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        println("Тип коллекции: " + collectionController.collectionType)
        println("Кол-во элементов: " + collectionController.size())
        println("Дата последней инициализации: " + collectionController.lastInitTime)
    }
}