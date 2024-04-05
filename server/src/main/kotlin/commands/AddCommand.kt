package commands

import ICollectionController
import collection.MusicBand

class AddCommand(private val collectionController: ICollectionController<*>) :
    ACommand("add", "Команда позволяет добавить новый элемент.", "Элемент успешно добавлен в коллекцию.") {
    override fun doIt(arg: Any?) {
        collectionController.add(arg!! as MusicBand)
    }
}
