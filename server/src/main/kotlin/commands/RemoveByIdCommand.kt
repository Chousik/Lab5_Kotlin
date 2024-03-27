package org.chousik.commands

import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class RemoveByIdCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_by_id", " {id} команда позволяет удалить элемент с введенным id", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        val id = args[0].toInt()
        collectionController.removeElementByID(id)
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}