package org.chousik

import org.chousik.collection.MusicBand
import org.chousik.commands.*
import org.chousik.database.AltJsonDB
import org.chousik.handlers.CollectionControllerMusicBand
import org.chousik.handlers.CommandHandler
import org.chousik.handlers.RunHandler
import java.io.File
import java.util.*
import kotlin.system.exitProcess

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size == 0) {

            println("Вы не ввели имя файла")
            exitProcess(0)
        }
        run(args[0])
    }


    fun run(fileName: String?) {
        val file = File(fileName.toString())
        if (!file.exists()) {
            println("Введенного файла не существует, создан новый")
            try {
                file.createNewFile()
            } catch (ignored: java.lang.Exception) {
            }
        }
        val jsonDB = AltJsonDB(fileName!!)
        val collectionControllerPerson =
            CollectionControllerMusicBand(jsonDB, LinkedList<MusicBand>())
        collectionControllerPerson.loadData()
        val commandHandler = CommandHandler()
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
        println("Начала работы! Для вывода списка команд используйте help.")
        runHandlerMain.consoleRun()
    }
}