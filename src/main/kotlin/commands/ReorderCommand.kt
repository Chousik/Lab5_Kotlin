package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class ReorderCommand(private val collectionController: ICollectionController<*>) :
    ACommand("reorder", "команда позволяет отсортирова коллекцию в обратном порядке.", 0) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        collectionController.reorder()
        if (!RunHandler.mode()) {
            println("Коллекция успешно реверснута")
        }
    }
}