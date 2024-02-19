package org.example.collection;

import java.util.LinkedList;

public enum Country{
    RUSSIA,
    UNITED_KINGDOM,
    GERMANY,
    VATICAN;
    public static String getValue() {
        LinkedList<String> EnumValues = new LinkedList<>();
        for (Country country : Country.values()){
            EnumValues.add(country.toString());
        }
        return String.join(", ", EnumValues);
    }
}