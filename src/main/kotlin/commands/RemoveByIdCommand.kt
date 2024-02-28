package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class RemoveByIdCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_by_id {id} ", "команда позволяет удалить элемент с введеным id", 1) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        try {
            val id = args[0]!!.toInt()
            collectionController.removeElementByID(id)
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}