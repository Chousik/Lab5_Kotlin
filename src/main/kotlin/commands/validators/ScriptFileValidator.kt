package org.chousik.commands.validators

import org.chousik.exception.ArgumentError
import java.io.File

class ScriptFileValidator {
    fun valid(fileName: String?) {
        val scriptFile = File(fileName!!)
        if (!scriptFile.exists()) {
            throw ArgumentError("Неверное имя файла")
        }
        if (!scriptFile.canRead()) {
            throw ArgumentError("Файл недоступен к чтению")
        }
    }
}