package commands

class CommandByType(
    private val mapCommands: Map<String, CommandType> =
        mapOf(
            "help" to CommandType.Help,
            "info" to CommandType.Info,
            "show" to CommandType.Show,
            "add" to CommandType.Add,
            "update" to CommandType.Update,
            "clear" to CommandType.Clear,
            "count_by_number_of_participants" to CommandType.CountByNumbersOfParticipants,
            "filter_by_albums_count" to CommandType.FilterByAlbumsCount,
            "remove_any_by_front_man" to CommandType.RemoveAnyByFrontMan,
            "remove_at" to CommandType.RemoveAt,
            "remove_by_id" to CommandType.RemoveById,
            "reorder" to CommandType.Reorder,
            "shuffle" to CommandType.Shuffle,
            "update" to CommandType.Update,
        ),
) {
    fun getTypeCommand(name: String): CommandType? {
        return mapCommands[name]
    }
}
