package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController

/**
 * Команда count_by_number_of_participants. Позволяет вывести количество элементов, с кол-вом участников равному введеному.
 */
class CountByNumbersOfParticipantsCommand(private val collectionController: ICollectionController<*>) : ACommand(
    "count_by_number_of_participants",
    "команда позволяет вывести количество элементов, с кол-вом участников равному введеному.",
    1
) {
    /**
     * Метод для вывода количества элементов, с кол-вом участников равному введеному.
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        try {
            val numbers = args[0]!!.toLong()
            println("Кол-во групп: " + collectionController.countNumberOfParticipants(numbers))
        } catch (e: NumberFormatException) {
            throw ArgumentError("Айди должно быть числом")
        }
    }
}