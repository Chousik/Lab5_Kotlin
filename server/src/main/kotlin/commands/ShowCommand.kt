package commands

import ICollectionController

class ShowCommand(private val collectionController: ICollectionController<*>) :
    ACommand("show", " команда позволяет вывести коллекцию.") {
    override fun doIt(arg: Any?) {
        successfullyInfo = collectionController.elements
    }
}
