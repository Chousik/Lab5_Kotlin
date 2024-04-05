package commands

import kotlin.system.exitProcess

class ExitCommand : ACommand("exit", "команда завершает работу программы") {
    override fun doIt(arg: Any?) {
        exitProcess(0)
    }
}
