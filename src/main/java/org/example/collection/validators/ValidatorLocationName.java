package org.example.collection.validators;

import org.example.exception.InvalidDataError;

public class ValidatorLocationName implements Validator<String>{
    @Override
    public void valide(String s) throws InvalidDataError {
        if (s == null) {
            return;
        }
        if (s.isBlank()|s.isEmpty()){
            throw new InvalidDataError();
        }
    }
}
