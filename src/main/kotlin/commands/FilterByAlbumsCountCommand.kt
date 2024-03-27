package commands

import org.chousik.handlers.ICollectionController


class FilterByAlbumsCountCommand(private val collectionController: ICollectionController<*>) :
    ACommand("filter_by_albums_count", "команда позволяет вывести группы с введенным числом альбомов", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        val integer = args[0].toInt()
        println(collectionController.getElementsByAlbumCount(integer))
    }
}