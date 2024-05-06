
import builders.CommandHandlerBuilder
import collection.MusicBand
import commands.AddCommand
import commands.ClearCommand
import commands.CommandType
import commands.CountByNumbersOfParticipantsCommand
import commands.ExecuteCommand
import commands.ExitCommand
import commands.FilterByAlbumsCountCommand
import commands.HelpCommand
import commands.InfoCommand
import commands.RemoveAnyByFrontManCommand
import commands.RemoveAtCommand
import commands.RemoveByIdCommand
import commands.ReorderCommand
import commands.SaveCommand
import commands.ShowCommand
import commands.ShuffleCommand
import commands.UpdateCommand
import database.AltJsonDB
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import request.FullRequest
import response.CommandResponse
import java.io.File
<<<<<<< HEAD
import java.util.LinkedList
=======
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock
>>>>>>> 40cc7ce (add_ReentrantLock)

suspend fun main(): Unit =
    coroutineScope {

        val requestChannel = Channel<FullRequest>()
        val clientChannel = Channel<CommandResponse>()
        val serverChannel = Channel<CommandResponse>()
        val filename = "data.json"
        val file = File(filename)
        if (!file.exists()) {
            file.createNewFile()
        }
        val server = ServerUDP()
        val collectionH = CollectionControllerMusicBand(AltJsonDB(filename), LinkedList<MusicBand>())
        val lock = ReentrantLock()
        val commandList =
            mapOf(
                CommandType.Add to AddCommand(collectionH, lock),
                CommandType.Info to InfoCommand(collectionH, lock),
                CommandType.Clear to ClearCommand(collectionH, lock),
                CommandType.Add to AddCommand(collectionH, lock),
                CommandType.Show to ShowCommand(collectionH, lock),
                CommandType.Save to SaveCommand(collectionH),
                CommandType.Clear to ClearCommand(collectionH, lock),
                CommandType.CountByNumbersOfParticipants to CountByNumbersOfParticipantsCommand(collectionH, lock),
                CommandType.FilterByAlbumsCount to FilterByAlbumsCountCommand(collectionH, lock),
                CommandType.RemoveAt to RemoveAtCommand(collectionH, lock),
                CommandType.Shuffle to ShuffleCommand(collectionH, lock),
                CommandType.Reorder to ReorderCommand(collectionH, lock),
                CommandType.RemoveAnyByFrontMan to RemoveAnyByFrontManCommand(collectionH, lock),
                CommandType.Exit to ExitCommand(),
                CommandType.Execute to ExecuteCommand(),
                CommandType.Update to UpdateCommand(collectionH, lock),
                CommandType.RemoveById to RemoveByIdCommand(collectionH, lock),
                CommandType.RemoveById to RemoveByIdCommand(collectionH, lock),
            )
        val commandsBuilder = CommandHandlerBuilder(commandList)
        val commands = commandsBuilder.addCommand(CommandType.Help, HelpCommand(commandList)).build()
        val executorC = CommandExecutor(commands)
        launch {
            val serverConsole = ServerConsole(requestChannel, serverChannel)
            serverConsole.consoleRun()
        }
        launch {
            val clientConnect = ClientConnect(requestChannel, clientChannel, server)
            clientConnect.run()
        }
        launch {
            val requestProcessor = RequestProcessor(executorC, requestChannel, clientChannel, serverChannel)
            requestProcessor.run()
        }
        Runtime.getRuntime().addShutdownHook(
            Thread {
                collectionH.saveData()
                ServerUDP.logger.info("Завершение работы сервера.")
            },
        )
    }
