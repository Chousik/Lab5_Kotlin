package org.example.collection.validators;

import org.example.collection.Color;
import org.example.exception.InvalidDataError;

public class ValidatorColor implements Validator<String>{
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException{
        try {
            Color.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
