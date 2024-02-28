package org.chousik.commands

import exeption.ArgumentError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class RemoveByIdCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_by_id {id} ", "команда позволяет удалить элемент с введенным id", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        try {
            val id = args[0].toInt()
            collectionController.removeElementByID(id)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}