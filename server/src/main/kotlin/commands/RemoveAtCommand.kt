package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class RemoveAtCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("remove_at", " {index} команда позволяет удалить элемент с введенным индексом.", "Элемент успешно удален") {
    override fun doIt(arg: Any?) {
        try {
            lock.lock()
            collectionController.removeElements(arg!! as Int)
        }finally {
            lock.unlock()
        }
    }
}
