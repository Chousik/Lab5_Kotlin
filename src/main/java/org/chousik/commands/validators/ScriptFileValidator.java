package org.chousik.commands.validators;

import org.chousik.exception.ArgumentError;

import java.io.File;

public class ScriptFileValidator {
    public void valid(String fileName) throws ArgumentError {
        File scriptFile = new File(fileName);
        if (!scriptFile.exists()) {
            throw new ArgumentError("Неверное имя файла");
        }
        if (!scriptFile.canRead()) {
            throw new ArgumentError("Файл недоступен к чтению");
        }
    }
}
