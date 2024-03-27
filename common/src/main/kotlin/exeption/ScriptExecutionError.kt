package exeption


class ScriptExecutionError(message: String) : Exception("ScriptExecutionError: $message") {
    override fun toString(): String {
        return message!!
    }
}