package commands

import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class ShuffleCommand(private val collectionController: ICollectionController<*>) :
    ACommand("shuffle", "команда позволяет перемешать элементы коллекции", 0) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        collectionController.shuffle()
        if (!RunHandler.mode()) {
            println("Коллекция успешно перемешана")
        }
    }
}