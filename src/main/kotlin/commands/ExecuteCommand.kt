package org.chousik.commands

import org.chousik.commands.validators.ScriptFileValidator
import org.chousik.commands.validators.ScriptRecursionValid
import org.chousik.handlers.RunHandler


class ExecuteCommand(private var runHandler: RunHandler, private val scriptFileValidator: ScriptFileValidator = ScriptFileValidator(), private val scriptRecursionValid: ScriptRecursionValid = ScriptRecursionValid()) :
    ACommand("execute", " {script_file} команда позволяет выполнить указанный скрипт", 1) {

    override fun execute(args: Array<String>) {
        validCountsArgument(args)
        scriptFileValidator.valid(args[0])
        scriptRecursionValid.valid(args[0])
        runHandler.scriptsRun(args[0])
    }
}