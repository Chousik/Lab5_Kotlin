package commands

import org.chousik.handlers.ICollectionController


class ShowCommand(private val collectionController: ICollectionController<*>) :
    ACommand("show", " команда позволяет вывести коллекцию.", 0) {
    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        println(collectionController.elements)
    }
}