
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
import java.util.LinkedList

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
        val commandList =
            mapOf(
                CommandType.Add to AddCommand(collectionH),
                CommandType.Info to InfoCommand(collectionH),
                CommandType.Clear to ClearCommand(collectionH),
                CommandType.Add to AddCommand(collectionH),
                CommandType.Show to ShowCommand(collectionH),
                CommandType.Save to SaveCommand(collectionH),
                CommandType.Clear to ClearCommand(collectionH),
                CommandType.CountByNumbersOfParticipants to CountByNumbersOfParticipantsCommand(collectionH),
                CommandType.FilterByAlbumsCount to FilterByAlbumsCountCommand(collectionH),
                CommandType.RemoveAt to RemoveAtCommand(collectionH),
                CommandType.Shuffle to ShuffleCommand(collectionH),
                CommandType.Reorder to ReorderCommand(collectionH),
                CommandType.RemoveAnyByFrontMan to RemoveAnyByFrontManCommand(collectionH),
                CommandType.Exit to ExitCommand(),
                CommandType.Execute to ExecuteCommand(),
                CommandType.Update to UpdateCommand(collectionH),
                CommandType.RemoveById to RemoveByIdCommand(collectionH),
                CommandType.RemoveById to RemoveByIdCommand(collectionH),
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
    }
