package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class RemoveByIdCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("remove_by_id", " {id} команда позволяет удалить элемент с введенным id", "Элемент успешно удален") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        try {
            lock.lock()
            collectionController.removeElementByID(arg!! as Int, id)
        } finally {
            lock.unlock()
        }
    }
}
