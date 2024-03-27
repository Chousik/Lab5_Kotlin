package commands

import ICollectionController


class ClearCommand(private val collectionController: ICollectionController<*>) :
    ACommand("clear", "команда позволяет очистить коллекцию.", "Коллекция успешно очищена") {
    override fun doIt(arg: Any?) {
        collectionController.clear()
    }
}