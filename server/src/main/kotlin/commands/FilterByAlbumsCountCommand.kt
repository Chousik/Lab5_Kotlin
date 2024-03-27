package commands

import ICollectionController


class FilterByAlbumsCountCommand(private val collectionController: ICollectionController<*>) :
    ACommand("filter_by_albums_count", "команда позволяет вывести группы с введенным числом альбомов") {
    override fun doIt(arg: Any?) {
        successfullyInfo = collectionController.getElementsByAlbumCount(arg!! as Int)
    }
}