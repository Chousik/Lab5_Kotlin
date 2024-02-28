package org.chousik.commands

import exeption.ArgumentError
import org.chousik.handlers.ICollectionController


class FilterByAlbumsCountCommand(private val collectionController: ICollectionController<*>) :
    ACommand("filter_by_albums_count", "команда позволяет вывести группы с введенным числом альбомов", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        try {
            val integer = args[0].toInt()
            println(collectionController.getElementsByAlbomCount(integer))
        } catch (e: NumberFormatException) {
            throw ArgumentError("Кол-во групп должно быть числом")
        }
    }
}