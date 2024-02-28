package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController


class FilterByAlbumsCountCommand(private val collectionController: ICollectionController<*>) :
    ACommand("filter_by_albums_count", "команда позволяет вывести группы с введеным числом альбомов", 1) {

    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        try {
            val integer = args[0]!!.toInt()
            println(collectionController.getElementsByAlbomCount(integer))
        } catch (e: NumberFormatException) {
            throw ArgumentError("Кол-во групп должно быть числом")
        }
    }
}