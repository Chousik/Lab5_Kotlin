package org.chousik.commands

import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class SaveCommand(private val collectionController: ICollectionController<*>) :
    ACommand("save", "команда позволяет сохранить данные в файл", 0) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        if (!RunHandler.mode() and collectionController.saveData()) {
            println("Данные успешно сохранены")
        }
    }
}