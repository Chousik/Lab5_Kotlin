package org.chousik.commands

import org.chousik.collection.Person
import org.chousik.collection.builder.BuilderPerson
import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.RunHandler


class RemoveAnyByFrontManCommand(var collectionController: ICollectionController<*>) :
    ACommand("remove_any_by_front_man", "команда позволяет удалить группы с введеным лидером.", 0) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        val person: Person = BuilderPerson().build()
        collectionController.removeByFrontMan(person)
        if (!RunHandler.mode()) {
            println("Элемент успешно удален")
        }
    }
}