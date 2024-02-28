package org.chousik.commands

import org.chousik.exception.ArgumentError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class UpdateCommand(private val collectionController: ICollectionController<*>) :
    ACommand("update", "команда позволяет обновить элемент с введенным айди", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        try {
            val id = args[0].toInt()
            collectionController.updateElements(id)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно обновлен")
        }
    }
}