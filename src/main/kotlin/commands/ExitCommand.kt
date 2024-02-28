package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError


class ExitCommand : ACommand("exit", "команда завершает работу программы", 0) {

    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        System.exit(0)
    }
}