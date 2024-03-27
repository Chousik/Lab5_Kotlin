package commands

import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class ClearCommand(private val collectionController: ICollectionController<*>) :
    ACommand("clear", "команда позволяет очистить коллекцию.", 0) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        collectionController.clear()
        if (!RunHandler.mode()) {
            println("Коллекция успешно очищена")
        }
    }
}