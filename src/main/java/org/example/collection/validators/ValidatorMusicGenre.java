package org.example.collection.validators;

import org.example.collection.MusicGenre;
import org.example.exception.NotValidData;

public class ValidatorMusicGenre implements Validator<String> {
    @Override
    public void valide(String s) throws NotValidData, NullPointerException {
        try {
            MusicGenre.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new NotValidData();
        }
    }
}
