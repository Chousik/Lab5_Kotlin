package commands

import ICollectionController
import collection.Person

class RemoveAnyByFrontManCommand(var collectionController: ICollectionController<*>) :
    ACommand("remove_any_by_front_man", "команда позволяет удалить группы с введенным лидером.", "Элемент успешно удален") {
    override fun doIt(arg: Any?) {
        collectionController.removeByFrontMan(arg!! as Person)
    }
}
