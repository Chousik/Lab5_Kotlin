import builders.CommandHandlerBuilder
import collection.MusicBand
import commands.*
import database.AltJsonDB
import java.io.File
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val filename = "data.json"
    val file = File(filename)
    if (!file.exists()){
        file.createNewFile()
    }
    val server = ServerUDP()
    val commandList = HashMap<CommandType, ACommand>()
    val collectionH = CollectionControllerMusicBand(AltJsonDB(filename), LinkedList<MusicBand>())
    val commandsBuilder = CommandHandlerBuilder(commandList).addCommand(CommandType.Add, AddCommand(collectionH)).addCommand(CommandType.Info, InfoCommand(collectionH)).addCommand(CommandType.Clear, ClearCommand(collectionH)).addCommand(CommandType.Add, AddCommand(collectionH))
    commandsBuilder.addCommand(CommandType.Help, HelpCommand(commandList)).addCommand(CommandType.Show, ShowCommand(collectionH)).addCommand(CommandType.Save, SaveCommand(collectionH)).addCommand(CommandType.Clear, ClearCommand(collectionH))
    commandsBuilder.addCommand(CommandType.CountByNumbersOfParticipants, CountByNumbersOfParticipantsCommand(collectionH)).addCommand(CommandType.FilterByAlbumsCount, FilterByAlbumsCountCommand(collectionH)).addCommand(CommandType.RemoveAt, RemoveAtCommand(collectionH))
    commandsBuilder.addCommand(CommandType.Shuffle, ShuffleCommand(collectionH)).addCommand(CommandType.Reorder, ReorderCommand(collectionH)).addCommand(CommandType.RemoveAnyByFrontMan, RemoveAnyByFrontManCommand(collectionH))
    commandsBuilder.addCommand(CommandType.Exit, ExitCommand()).addCommand(CommandType.Execute, ExecuteCommand())
    val commands = commandsBuilder.build()
    var executorC = CommandExecutor(commands)
    while (true){
        var request = server.readRequest()
        server.sendResponse(executorC.execute(request))
    }
}