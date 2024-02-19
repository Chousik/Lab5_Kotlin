package org.example.collection.validators;

import org.example.collection.MusicGenre;
import org.example.exception.InvalidDataError;

public class ValidatorMusicGenre implements Validator<String> {
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException {
        try {
            MusicGenre.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
