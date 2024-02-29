package org.chousik.commands

import exeption.ArgumentError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class RemoveAtCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_at", " {index} команда позволяет удалить элемент с введенным индексом.", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        try {
            val index = args[0].toInt()
            collectionController.removeElements(index)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}