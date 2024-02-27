package org.chousik.commands.validators

import org.chousik.exception.ArgumentError
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Paths
import java.util.*

/**
 * Класс для проверки рекурсии в скрипте
 */
class ScriptRecursionValidor {
    /**
     * Метод для проверки рекурсии в скрипте
     *
     * @param fileName имя файла
     * @throws ArgumentError если скрипт содержит рекурсию
     */
    @Throws(ArgumentError::class)
    fun valid(fileName: String?) {
        var fileName = fileName
        var scriptFile = File(fileName)
        val urlList = LinkedList<String>()
        val nextFiles: Queue<String?> = PriorityQueue()
        nextFiles.add(fileName)
        while (!nextFiles.isEmpty()) {
            fileName = nextFiles.poll()
            fileName = Paths.get(fileName).toAbsolutePath().toString()
            if (inUrlList(urlList, fileName)) {
                throw ArgumentError("Скрипт содержит рекурсию")
            }

            urlList.add(fileName)
            scriptFile = File(fileName)
            if (scriptFile.exists()) {
                try {
                    val fileScanner = Scanner(scriptFile)
                    while (fileScanner.hasNext()) {
                        val fileLine = fileScanner.nextLine()
                        if (fileLine.startsWith("execute")) {
                            nextFiles.add(fileLine.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
                                .toTypedArray()[1])
                        }
                    }
                } catch (e: FileNotFoundException) {
                    throw ArgumentError("Скрипт пытается вызвать несуществующий скрипт.")
                }
            }
        }
    }

    /**
     * Метод для проверки наличия файла в списке файлов
     *
     * @param urlList  список файлов
     * @param fileName имя файла
     * @return возвращает true, если файл есть в списке, иначе false
     */
    private fun inUrlList(urlList: LinkedList<String>, fileName: String): Boolean {
        return !urlList.stream().filter { x: String -> x == fileName }.toList().isEmpty()
    }
}