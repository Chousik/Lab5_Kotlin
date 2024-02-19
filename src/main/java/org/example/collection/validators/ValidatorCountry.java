package org.example.collection.validators;

import org.example.collection.Country;
import org.example.exception.InvalidDataError;

public class ValidatorCountry implements Validator<String>{
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException {
        try {
            Country.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
