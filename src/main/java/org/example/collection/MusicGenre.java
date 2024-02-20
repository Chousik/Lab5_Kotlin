package org.example.collection;

import java.util.LinkedList;
/**
 * Класс перечисление жанров музыки
 */
public enum MusicGenre{
    JAZZ,
    SOUL,
    POP;
    /**
     * @return возвращает все значения перечисления
     */
    public static String getValue() {
        LinkedList<String> enumValues = new LinkedList<>();
        for (MusicGenre genre :  MusicGenre.values()){
            enumValues.add(genre.toString());
        }
        return String.join(", ", enumValues);
    }
}