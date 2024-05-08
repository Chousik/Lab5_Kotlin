package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class ReorderCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand(
        "reorder",
        "команда позволяет отсортирована коллекцию в обратном порядке.",
        "Коллекция успешно отсортирована в обратом порядке.",
    ) {
    override fun doIt(arg: Any?, id: Int) {
        try {
            lock.lock()
            collectionController.reorder()
        }finally {
            lock.unlock()
        }
    }
}
