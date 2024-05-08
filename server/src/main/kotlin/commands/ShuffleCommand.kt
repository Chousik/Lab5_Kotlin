package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class ShuffleCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("shuffle", "команда позволяет перемешать элементы коллекции", "Коллекция успешно перемешана") {
    override fun doIt(arg: Any?, id: Int) {
        try {
            lock.lock()
            collectionController.shuffle()
        }finally {
            lock.unlock()
        }
    }
}
