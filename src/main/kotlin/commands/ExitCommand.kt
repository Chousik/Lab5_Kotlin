package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import kotlin.system.exitProcess


class ExitCommand : ACommand("exit", "команда завершает работу программы", 0) {

    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        exitProcess(0)
    }
}