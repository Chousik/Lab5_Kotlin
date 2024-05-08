package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class FilterByAlbumsCountCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("filter_by_albums_count", "команда позволяет вывести группы с введенным числом альбомов") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        try {
            lock.lock()
            successfullyInfo = collectionController.getElementsByAlbumCount(arg!! as Int)
        } finally {
            lock.unlock()
        }
    }
}
