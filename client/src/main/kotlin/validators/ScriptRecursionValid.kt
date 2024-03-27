package org.chousik.commands.validators

import exeption.ArgumentError
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Paths
import java.util.*

class ScriptRecursionValid {
    fun valid(fileNameIn: String) {
        var fileName = fileNameIn
        val urlList = LinkedList<String>()
        val nextFiles: Queue<String> = PriorityQueue()
        nextFiles.add(fileName)
        while (!nextFiles.isEmpty()) {
            fileName = nextFiles.poll()
            fileName = Paths.get(fileName).toAbsolutePath().toString()
            if (inUrlList(urlList, fileName)) {
                throw ArgumentError("Скрипт содержит рекурсию")
            }

            urlList.add(fileName)
            val scriptFile = File(fileName)
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


    private fun inUrlList(urlList: LinkedList<String>, fileName: String): Boolean {
        return urlList.stream().filter { x: String -> x == fileName }.toList().isEmpty()
    }
}