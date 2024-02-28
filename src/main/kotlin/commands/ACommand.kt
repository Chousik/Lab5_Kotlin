package org.chousik.commands

import exeption.ArgumentCountError


abstract class ACommand(private val name: String, private val info: String, private val countsArgument: Int) {

    fun validCountsArgument(args: Array<String>) {
        if (args.size != countsArgument) {
            throw ArgumentCountError(countsArgument, args.size)
        }
    }

    abstract fun execute(args: Array<String>)

    override fun toString(): String {
        return this.name + ": " + this.info
    }
}