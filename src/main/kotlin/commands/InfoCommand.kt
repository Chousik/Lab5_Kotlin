package commands

import org.chousik.handlers.ICollectionController


class InfoCommand(private val collectionController: ICollectionController<*>) :
    ACommand("info", "команда позволяет увидеть информацию о коллекции.", 0) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        println("Тип коллекции: " + collectionController.collectionType)
        println("Кол-во элементов: " + collectionController.size())
        println("Дата последней инициализации: " + collectionController.lastInitTime)
    }
}