package org.chousik.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Класс перечисление стран
 */
public enum Country {
    RUSSIA,
    UNITED_KINGDOM,
    GERMANY,
    VATICAN;

    /**
     * @return возвращает все значения перечисления
     */
    public static String getValue() {
        return Arrays.stream(Country.values())
                .map(Country::name)
                .collect(Collectors.joining(", "));
    }
}