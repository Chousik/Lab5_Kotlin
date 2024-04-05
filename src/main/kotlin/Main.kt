package org.chousik

import handlers.builders.CommandHandlerBuilder
import org.chousik.collection.MusicBand
import org.chousik.commands.*
import org.chousik.database.AltJsonDB
import org.chousik.database.IDataBase
import org.chousik.handlers.CollectionControllerMusicBand
import org.chousik.handlers.RunHandler
import java.io.File
import java.util.*
import kotlin.system.exitProcess

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("Вы не ввели имя файла")
            exitProcess(0)
        }
        run(args[0])
    }

    private fun run(fileName: String) {
        val file = File(fileName)
        if (!file.exists()) {
            println("Введенного файла не существует, создан новый")
            try {
                file.createNewFile()
            } catch (ignored: java.lang.Exception) {
            }
        }
        val jsonDB: IDataBase<MusicBand> = AltJsonDB(fileName)
        val collectionControllerPerson =
            CollectionControllerMusicBand(jsonDB, LinkedList<MusicBand>())
        collectionControllerPerson.loadData()
        val commandMap = HashMap<String, ACommand>()
        val commandHandler = CommandHandlerBuilder(commandMap).addCommands(listOf(AddCommand(collectionControllerPerson), InfoCommand(collectionControllerPerson), ShowCommand(collectionControllerPerson),
            UpdateCommand(collectionControllerPerson),RemoveByIdCommand(collectionControllerPerson), ClearCommand(collectionControllerPerson), RemoveAtCommand(collectionControllerPerson),
            ShuffleCommand(collectionControllerPerson), ReorderCommand(collectionControllerPerson),RemoveAnyByFrontManCommand(collectionControllerPerson),
            CountByNumbersOfParticipantsCommand(collectionControllerPerson), FilterByAlbumsCountCommand(collectionControllerPerson), SaveCommand(collectionControllerPerson),
            ExitCommand(), HelpCommand(commandMap))).build()
        val runHandlerMain = RunHandler(commandHandler)
        commandHandler.addCommand("execute", ExecuteCommand(runHandlerMain))
        println("Начала работы! Для вывода списка команд используйте help.")
        runHandlerMain.consoleRun()
    }
}
