package commands

import ICollectionController

class RemoveByIdCommand(private val collectionController: ICollectionController<*>) :
    ACommand("remove_by_id", " {id} команда позволяет удалить элемент с введенным id", "Элемент успешно удален") {
    override fun doIt(arg: Any?) {
        collectionController.removeElementByID(arg!! as Int)
    }
}
