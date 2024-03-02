package org.chousik.commands

import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class UpdateCommand(private val collectionController: ICollectionController<*>) :
    ACommand("update", "команда позволяет обновить элемент с введенным айди", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        val id = args[0].toInt()
        collectionController.updateElements(id)
        if (!RunHandler.mode()) {
            println("Элемент успешно обновлен")
        }
    }
}