package org.chousik.collection;

import java.util.LinkedList;

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
        LinkedList<String> enumValues = new LinkedList<>();
        for (Color color : Color.values()) {
            enumValues.add(color.toString());
        }
        return String.join(", ", enumValues);
    }
}