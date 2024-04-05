package exeption

class ArgumentCountError(private var countCorrect: Int, private var count: Int) : Exception() {
    override fun toString(): String {
        return "Неверное кол-во аргумент: $count, Должно быть: $countCorrect."
    }
}
