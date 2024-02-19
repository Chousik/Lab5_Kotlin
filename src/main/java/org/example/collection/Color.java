package org.example.collection;

import java.util.LinkedList;
import java.util.Map;

public enum Color{
    GREEN,
    YELLOW,
    ORANGE,
    BROWN;

    public static String getValue() {
        LinkedList<String> EnumValues = new LinkedList<>();
        for (Color color : Color.values()){
            EnumValues.add(color.toString());
        }
        return String.join(", ", EnumValues);
    }
}