package org.chousik.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Класс перечисление жанров музыки
 */
public enum MusicGenre {
    JAZZ,
    SOUL,
    POP;

    /**
     * @return возвращает все значения перечисления
     */
    public static String getValue() {
        return Arrays.stream(MusicGenre.values())
                .map(MusicGenre::name)
                .collect(Collectors.joining(", "));
    }
}