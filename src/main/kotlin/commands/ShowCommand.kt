package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController


class ShowCommand(private val collectionController: ICollectionController<*>) :
    ACommand("show", " команда позволяет вывести коллекцию.", 0) {
    @Throws(ArgumentCountError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        println(collectionController.elements)
    }
}