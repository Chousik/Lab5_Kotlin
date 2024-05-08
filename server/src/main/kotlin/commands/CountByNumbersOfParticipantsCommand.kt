package commands

import ICollectionController
import java.util.concurrent.locks.ReentrantLock

class CountByNumbersOfParticipantsCommand(private val collectionController: ICollectionController<*>, private val lock: ReentrantLock) : ACommand(
    "count_by_number_of_participants",
    "команда позволяет вывести количество элементов, с кол-вом участников равному введенному.",
) {
    override fun doIt(arg: Any?, id: Int) {
        try {
            lock.lock()
            successfullyInfo = "Кол-во групп: ${collectionController.countNumberOfParticipants(arg!! as Long)}"
        }finally {
            lock.unlock()
        }
    }
}
