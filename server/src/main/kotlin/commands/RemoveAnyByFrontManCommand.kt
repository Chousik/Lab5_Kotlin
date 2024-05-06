package commands

import ICollectionController
import collection.Person
import java.util.concurrent.locks.ReentrantLock

class RemoveAnyByFrontManCommand(var collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("remove_any_by_front_man", "команда позволяет удалить группы с введенным лидером.", "Элемент успешно удален") {
    override fun doIt(arg: Any?) {
        try {
            lock.lock()
            collectionController.removeByFrontMan(arg!! as Person)
        }finally {
            lock.unlock()
        }
    }
}
