package org.example.collection.validators;

import org.example.collection.Country;
import org.example.exception.NotValidData;

public class ValidatorCountry implements Validator<String>{
    @Override
    public void valide(String s) throws NotValidData, NullPointerException {
        try {
            Country.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new NotValidData();
        }
    }
}
