package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class InfoCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) :
    ACommand("info", "команда позволяет увидеть информацию о коллекции.") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        try {
            lock.lock()
            val builder = StringBuilder()
            builder.append("Тип коллекции:  ${collectionController.collectionType}\n")
            builder.append("Кол-во элементов: ${collectionController.size()} \n")
            builder.append("Дата последней инициализации: ${collectionController.lastInitTime}")
            successfullyInfo = builder.toString()
        } finally {
            lock.unlock()
        }
    }
}
