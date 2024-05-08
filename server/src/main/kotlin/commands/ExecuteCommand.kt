package commands

class ExecuteCommand : ACommand("execute", " {script_file} команда позволяет выполнить указанный скрипт") {
    override fun doIt(
        arg: Any?,
        id: Int,
    ) {
        successfullyInfo = "Скрипт успешно выполнен."
    }
}
