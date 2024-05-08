package commands

import ICollectionController
import collection.MusicBand
import java.util.concurrent.locks.ReentrantLock

class UpdateCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("update", "команда позволяет обновить элемент с введенным айди", "Элемент успешно обновлен") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        try {
            lock.lock()
            val arguments = arg!! as Array<*>
            collectionController.updateElements(arguments[0] as Int, id, arguments[1] as MusicBand)
        } finally {
            lock.unlock()
        }
    }
}
