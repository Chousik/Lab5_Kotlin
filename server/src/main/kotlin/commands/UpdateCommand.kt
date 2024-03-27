package commands

import ICollectionController
import collection.MusicBand


class UpdateCommand(private val collectionController: ICollectionController<*>) :
    ACommand("update", "команда позволяет обновить элемент с введенным айди", "Элемент успешно обновлен") {
    override fun doIt(arg: Any?) {
        val arguments = arg!! as Array<*>
        collectionController.updateElements(arguments[0] as Int, arguments[1] as MusicBand)
    }
}