package commands

import ICollectionController
import collection.MusicBand
import java.util.concurrent.locks.ReentrantLock

class AddCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("add", "Команда позволяет добавить новый элемент.", "Элемент успешно добавлен в коллекцию.") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        try {
            lock.lock()
            collectionController.add(arg!! as MusicBand, id)
        } finally {
            lock.unlock()
        }
    }
}
