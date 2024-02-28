package org.chousik.commands

import org.chousik.commands.validators.ScriptFileValidator
import org.chousik.commands.validators.ScriptRecursionValidor
import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import org.chousik.handlers.RunHandler


class ExecuteCommand(var runHandler: RunHandler) :
    ACommand("execute {sctipt_file}", "команда позволяет выполнить указанный скрипт", 1) {

    @Throws(ArgumentCountError::class, ScriptExecutionError::class, ArgumentError::class)
    override fun execute(args: Array<String?>?) {
        valideCountsArgument(args!!)
        ScriptFileValidator().valid(args[0])
        ScriptRecursionValidor().valid(args[0])
        runHandler.scriptsRun(args[0])
    }
}