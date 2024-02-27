package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError

/**
 * Абстрактный класс для команд
 */
abstract class ACommand(private val name: String, private val info: String, private val countsArgument: Int) {
    /**
     * Метод для проверки количества аргументов
     *
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    @Throws(ArgumentCountError::class)
    fun valideCountsArgument(args: Array<String?>) {
        if (args.size != countsArgument) {
            throw ArgumentCountError(countsArgument, args.size)
        }
    }

    /**
     * Метод для выполнения команды
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    abstract fun execute(args: Array<String?>?)

    override fun toString(): String {
        return this.name + ": " + this.info
    }
}