package org.chousik.commands

import exeption.ArgumentCountError


abstract class ACommand(private val _name: String, private val info: String, private val countsArgument: Int) {
    val name: String
        get() {
            return _name
        }

    fun validCountsArgument(args: Array<String>) {
        if (args.size != countsArgument) {
            throw ArgumentCountError(countsArgument, args.size)
        }
    }

    abstract fun execute(args: Array<String>)

    override fun toString(): String {
        return this._name + ": " + this.info
    }
}