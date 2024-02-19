package org.example.collection;

import java.util.LinkedList;

public enum MusicGenre{
    JAZZ,
    SOUL,
    POP;
    public static String getValue() {
        LinkedList<String> enumValues = new LinkedList<>();
        for (MusicGenre genre :  MusicGenre.values()){
            enumValues.add(genre.toString());
        }
        return String.join(", ", enumValues);
    }
}