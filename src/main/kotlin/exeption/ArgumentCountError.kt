package org.chousik.exception


class ArgumentCountError(var сountCorrect: Int, var сount: Int) : Exception() {
    override fun toString(): String {
        return "Неверное кол-во аргумент: $сount, Должно быть: $сountCorrect."
    }
}