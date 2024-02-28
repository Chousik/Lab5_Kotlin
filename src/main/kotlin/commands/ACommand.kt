package org.chousik.commands

import org.chousik.exception.ArgumentCountError
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError


abstract class ACommand(private val name: String, private val info: String, private val countsArgument: Int) {

    @Throws(ArgumentCountError::class)
    fun valideCountsArgument(args: Array<String?>) {
        if (args.size != countsArgument) {
            throw ArgumentCountError(countsArgument, args.size)
        }
    }


    abstract fun execute(args: Array<String?>?)

    override fun toString(): String {
        return this.name + ": " + this.info
    }
}