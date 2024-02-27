package org.chousik.commands

import org.chousik.collection.MusicBand
import org.chousik.collection.builder.BuilderMusicBand
import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler

/**
 * Команда add. Позволяет добавить новый элемент в коллекцию.
 */
class AddCommand(private val collectionController: ICollectionController<*>) :
    ACommand("add", "Команда позволяет добавить новый элемент.", 0) {
    /**
     * Метод для добавления элемента в коллекцию
     *
     * @param args аргументы
     * @throws ArgumentCountError   если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     */
    @Throws(ArgumentCountError::class, ScriptExecutionError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        val musicBand: MusicBand = BuilderMusicBand().build()
        collectionController.add(musicBand)
        if (!RunHandler.mode()) {
            println("Элемент успешно добавлен")
        }
    }
}