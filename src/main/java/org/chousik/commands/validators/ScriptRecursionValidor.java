package org.chousik.commands.validators;

import org.chousik.exception.ArgumentError;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Класс для проверки рекурсии в скрипте
 */
public class ScriptRecursionValidor {
    /**
     * Метод для проверки рекурсии в скрипте
     *
     * @param fileName имя файла
     * @throws ArgumentError если скрипт содержит рекурсию
     */
    public void valid(String fileName) throws ArgumentError {
        File scriptFile = new File(fileName);
        LinkedList<String> urlList = new LinkedList<>();
        Queue<String> nextFiles = new PriorityQueue<>();
        nextFiles.add(fileName);
        while (!nextFiles.isEmpty()) {
            fileName = nextFiles.poll();
            fileName = String.valueOf(Paths.get(fileName).toAbsolutePath());
            if (inUrlList(urlList, fileName)) {
                throw new ArgumentError("Скрипт содержит рекурсию");
            }
            ;
            urlList.add(fileName);
            scriptFile = new File(fileName);
            if (scriptFile.exists()) {
                try {
                    Scanner fileScanner = new Scanner(scriptFile);
                    while (fileScanner.hasNext()) {
                        String fileLine = fileScanner.nextLine();
                        if (fileLine.startsWith("execute")) {
                            nextFiles.add(fileLine.split("\\s+")[1]);
                        }
                    }
                } catch (FileNotFoundException ignore) {
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
    private boolean inUrlList(LinkedList<String> urlList, String fileName) {
        return !urlList.stream().filter(x -> x.equals(fileName)).toList().isEmpty();
    }
}
