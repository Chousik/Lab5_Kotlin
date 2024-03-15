package org.chousik.commands

import exeption.ArgumentCountError


abstract class ACommand(private val nameValue: String, private val info: String, private val countsArgument: Int) {
    val name: String
        get() {
            return nameValue
        }

    fun validCountsArgument(args: Array<String>) {
        if (args.size != countsArgument) {
            throw ArgumentCountError(countsArgument, args.size)
        }
    }

    abstract fun execute(args: Array<String>)

    override fun toString(): String {
        return this.nameValue + ": " + this.info
    }
}