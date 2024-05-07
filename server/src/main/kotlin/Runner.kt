
import builders.CommandHandlerBuilder
import collection.MusicBand
import commands.*
import database.AltJsonDB
import database.SqlDB
import java.io.File
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock

fun main(){
        val readRequestThread = Executors.newFixedThreadPool(2)
        val responseThreadPool = Executors.newCachedThreadPool()
        val sqlDB = SqlDB()
        val filename = "data.json"
        val file = File(filename)
        if (!file.exists()) {
            file.createNewFile()
        }
        val server = ServerUDP()
        val collectionH = CollectionControllerMusicBand(AltJsonDB(filename), sqlDB, LinkedList<MusicBand>())
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
        val requestProcessor = RequestProcessor(executorC,sqlDB)
        readRequestThread.execute{
            val serverConsole = ServerConsole(responseThreadPool, requestProcessor)
            serverConsole.consoleRun()
        }
        readRequestThread.execute{
            val clientConnect = ClientConnect(responseThreadPool, server, requestProcessor)
            clientConnect.run()
        }
    }
