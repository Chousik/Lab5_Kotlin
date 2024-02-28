package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class RemoveAtCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_at {index} ", "команда позволяет удалить элемент с введеным индексом.", 1) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        try {
            val index = args[0]!!.toInt()
            collectionController.removeElements(index)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}