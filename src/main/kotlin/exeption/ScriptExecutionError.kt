package org.chousik.exception

/**
 * Класс ошибки выполнения скрипта
 */
class ScriptExecutionError(message: String) : Exception("ScriptExecutionError: $message") {
    override fun toString(): String {
        return message!!
    }
}