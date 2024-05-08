package commands

import kotlin.system.exitProcess

class ExitCommand : ACommand("exit", "команда завершает работу программы") {
    override fun doIt(arg: Any?, id: Int) {
        exitProcess(0)
    }
}
