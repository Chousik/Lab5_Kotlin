package commands

class HelpCommand(private val commandMap: Map<CommandType, ACommand>) :
    ACommand("help", "команда позволяет получить список доступных команд.") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        successfullyInfo = (commandMap.values.joinToString("\n"))
    }
}
