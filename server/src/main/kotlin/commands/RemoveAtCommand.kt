package commands

import ICollectionController


class RemoveAtCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_at", " {index} команда позволяет удалить элемент с введенным индексом.", "Элемент успешно удален") {

    override fun doIt(arg: Any?) {
        collectionController.removeElements(arg!! as Int)
    }
}