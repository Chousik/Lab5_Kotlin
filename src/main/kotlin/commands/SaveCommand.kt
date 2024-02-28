package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class SaveCommand(private val collectionController: ICollectionController<*>) :
    ACommand("save", "команда позволяет сохранить данные в файл", 0) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        if (!RunHandler.mode() and collectionController.saveData()) {
            println("Данные успешно сохранены")
        }
    }
}