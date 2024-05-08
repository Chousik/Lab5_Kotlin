package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class ClearCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("clear", "команда позволяет очистить коллекцию.", "Коллекция успешно очищена") {
    override fun doIt(arg: Any?, id: Int) {
        try {
            lock.lock()
            collectionController.clear(id)
        }finally {
            lock.unlock()
        }
    }
}
