package commands

import kotlin.system.exitProcess


class ExitCommand : ACommand("exit", "команда завершает работу программы", 0) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        exitProcess(0)
    }
}