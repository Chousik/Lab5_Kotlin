package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class ClearCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("clear", "команда позволяет очистить коллекцию.", "Коллекция успешно очищена") {
    override fun doIt(arg: Any?) {
        try {
            lock.lock()
            collectionController.clear()
        }finally {
            lock.unlock()
        }
    }
}
