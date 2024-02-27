package org.chousik.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Класс перечисление цветов
 */
public enum Color {
    GREEN,
    YELLOW,
    ORANGE,
    BROWN;

    /**
     * @return возвращает все значения перечисления
     */
    public static String getValue() {
        return Arrays.stream(Color.values())
                .map(Color::name)
                .collect(Collectors.joining(", "));
    }
}