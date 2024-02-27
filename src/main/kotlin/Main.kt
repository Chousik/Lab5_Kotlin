package org.chousik

import org.chousik.collection.MusicBand
import org.chousik.commands.*
import org.chousik.database.AltJsonDB
import org.chousik.database.IDataBase
import org.chousik.handlers.ICollectionController
import org.chousik.handlers.CollectionControllerMusicBand
import org.chousik.handlers.CommandHandler
import org.chousik.handlers.RunHandler
import java.io.File
import java.util.*

object Main {
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {
        if (args.size == 0) {
            java.lang.System.err.println("Вы не ввели имя файла")
            java.lang.System.exit(0)
        }
        run(args[0])
    }


    fun run(fileName: String?) {
        val file: File = File(fileName)
        if (!file.exists()) {
            println("Введенного файла не существует, создан новый")
            try {
                file.createNewFile()
            } catch (ignored: java.lang.Exception) {
            }
        }
        val jsonDB: IDataBase<MusicBand> = AltJsonDB(fileName)
        val collectionControllerPerson: ICollectionController<MusicBand> =
            CollectionControllerMusicBand(jsonDB, LinkedList<MusicBand>())
        collectionControllerPerson.loadData()
        val commandHandler: CommandHandler = CommandHandler()
        commandHandler.addCommand("add", AddCommand(collectionControllerPerson))
        commandHandler.addCommand("help", HelpCommand(commandHandler))
        commandHandler.addCommand("info", InfoCommand(collectionControllerPerson))
        commandHandler.addCommand("show", ShowCommand(collectionControllerPerson))
        commandHandler.addCommand("update", UpdateCommand(collectionControllerPerson))
        commandHandler.addCommand("remove_by_id", RemoveByIdCommand(collectionControllerPerson))
        commandHandler.addCommand("clear", ClearCommand(collectionControllerPerson))
        commandHandler.addCommand("remove_at", RemoveAtCommand(collectionControllerPerson))
        commandHandler.addCommand("shuffle", ShuffleCommand(collectionControllerPerson))
        commandHandler.addCommand("reorder", ReorderCommand(collectionControllerPerson))
        commandHandler.addCommand("remove_any_by_front_man", RemoveAnyByFrontManCommand(collectionControllerPerson))
        commandHandler.addCommand(
            "count_by_number_of_participants",
            CountByNumbersOfParticipantsCommand(collectionControllerPerson)
        )
        commandHandler.addCommand("filter_by_albums_count", FilterByAlbumsCountCommand(collectionControllerPerson))
        commandHandler.addCommand("save", SaveCommand(collectionControllerPerson))
        commandHandler.addCommand("exit", ExitCommand())
        val runHandlerMain: RunHandler = RunHandler(collectionControllerPerson, commandHandler)
        commandHandler.addCommand("execute", ExecuteCommand(runHandlerMain))
        println("Начала работы! Для вывода списка комманд используйте help.")
        runHandlerMain.consoleRun()
    }
}