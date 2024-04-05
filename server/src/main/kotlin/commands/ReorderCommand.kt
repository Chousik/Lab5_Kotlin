package commands

import ICollectionController

class ReorderCommand(private val collectionController: ICollectionController<*>) :
    ACommand(
        "reorder",
        "команда позволяет отсортирована коллекцию в обратном порядке.",
        "Коллекция успешно отсортирована в обратом порядке.",
    ) {
    override fun doIt(arg: Any?) {
        collectionController.reorder()
    }
}
