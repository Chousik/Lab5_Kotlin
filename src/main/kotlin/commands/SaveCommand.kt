package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда save. Позволяет сохранить данные в файл
 */
class SaveCommand(private val collectionController: ICollectionController<*>) :
    ACommand("save", "команда позволяет сохранить данные в файл", 0) {
    /**
     * Метод для сохранения данных в файл
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError        если аргументы не корректны
     */
    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        if (!RunHandler.mode() and collectionController.saveData()) {
            println("Данные успешно сохранены")
        }
    }
}