package commands

import org.chousik.handlers.ICollectionController


class CountByNumbersOfParticipantsCommand(private val collectionController: ICollectionController<*>) : ACommand(
    "count_by_number_of_participants",
    "команда позволяет вывести количество элементов, с кол-вом участников равному введенному.",
    1
) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        val numbers = args[0].toLong()
        println("Кол-во групп: " + collectionController.countNumberOfParticipants(numbers))
    }
}