package commands

import ICollectionController
import commands.ACommand


class InfoCommand(private val collectionController: ICollectionController<*>) :
    ACommand("info", "команда позволяет увидеть информацию о коллекции.") {
    override fun doIt(arg: Any?) {
        val builder = StringBuilder()
        builder.append("Тип коллекции:  ${collectionController.collectionType}\n")
        builder.append("Кол-во элементов: ${collectionController.size()} \n")
        builder.append("Дата последней инициализации: ${collectionController.lastInitTime}")
        successfullyInfo = builder.toString()
    }
}