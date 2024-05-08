package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class ShowCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("show", " команда позволяет вывести коллекцию.") {
    override fun doIt(arg: Any?, id: Int) {
        try {
            lock.lock()
            successfullyInfo = collectionController.elements
        }finally {
            lock.unlock()
        }
    }
}
