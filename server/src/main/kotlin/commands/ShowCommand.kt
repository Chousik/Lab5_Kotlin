package commands

import ICollectionController
import commands.ACommand
import java.util.*


class ShowCommand(private val collectionController: ICollectionController<*>) :
    ACommand("show", " команда позволяет вывести коллекцию.") {

    override fun doIt(arg: Any?) {

        successfullyInfo = collectionController.elements
    }
}