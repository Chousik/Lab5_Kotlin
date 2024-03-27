package exeption


class InvalidCommandError(private val command: String) : Exception("InvalidCommandError") {
    override fun toString(): String {
        return this.message + ": команда " + command + " не найдена."
    }
}