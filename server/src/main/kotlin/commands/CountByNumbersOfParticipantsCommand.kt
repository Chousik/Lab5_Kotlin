package commands

import ICollectionController

class CountByNumbersOfParticipantsCommand(private val collectionController: ICollectionController<*>) : ACommand(
    "count_by_number_of_participants",
    "команда позволяет вывести количество элементов, с кол-вом участников равному введенному.",
) {
    override fun doIt(arg: Any?) {
        successfullyInfo = "Кол-во групп: ${collectionController.countNumberOfParticipants(arg!! as Long)}"
    }
}
