package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController


class InfoCommand(private val collectionController: ICollectionController<*>) :
    ACommand("info", "команда позволяет увидеть информацию о коллекции.", 0) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        println("Тип коллекции: " + collectionController.collectionType)
        println("Кол-во элементов: " + collectionController.size())
        println("Дата последней инициализации: " + collectionController.lastInitTime)
    }
}