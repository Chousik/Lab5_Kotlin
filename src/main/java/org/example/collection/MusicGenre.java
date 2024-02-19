package org.example.collection;

import java.util.LinkedList;

public enum MusicGenre{
    JAZZ,
    SOUL,
    POP;
    public static String getValue() {
        LinkedList<String> EnumValues = new LinkedList<>();
        for (MusicGenre genre :  MusicGenre.values()){
            EnumValues.add(genre.toString());
        }
        return String.join(", ", EnumValues);
    }
}