package org.chousik.collection;

import java.util.LinkedList;

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
        LinkedList<String> EnumValues = new LinkedList<>();
        for (Country country : Country.values()) {
            EnumValues.add(country.toString());
        }
        return String.join(", ", EnumValues);
    }
}