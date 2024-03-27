package commands

class CommandByType(private val mapCommands: HashMap<String, CommandType> = HashMap()) {
    fun register(commandName: String, commandType: CommandType) {
        mapCommands[commandName] = commandType
    }
    init {
        mapCommands["help"] = CommandType.Help
        mapCommands["info"] = CommandType.Info
        mapCommands["show"] = CommandType.Show
        mapCommands["add"] = CommandType.Add
        mapCommands["update"] = CommandType.Update
        mapCommands["clear"] = CommandType.Clear
        mapCommands["count_by_number_of_participants"] = CommandType.CountByNumbersOfParticipants
        mapCommands["filter_by_albums_count"] = CommandType.FilterByAlbumsCount
        mapCommands["remove_any_by_front_man"] = CommandType.RemoveAnyByFrontMan
        mapCommands["remove_at"] = CommandType.RemoveAt
        mapCommands["remove_by_id"] = CommandType.RemoveById
        mapCommands["reorder"] = CommandType.Reorder
        mapCommands["shuffle"] = CommandType.Shuffle
        mapCommands["update"] = CommandType.Update
    }
    fun getTypeCommand(name: String): CommandType? {
        return mapCommands[name]
    }
}