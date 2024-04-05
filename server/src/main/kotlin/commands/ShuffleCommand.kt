package commands

import ICollectionController

class ShuffleCommand(private val collectionController: ICollectionController<*>) :
    ACommand("shuffle", "команда позволяет перемешать элементы коллекции", "Коллекция успешно перемешана") {
    override fun doIt(arg: Any?) {
        collectionController.shuffle()
    }
}
