package org.example.collection.validators;

import org.example.exception.InvalidDataError;

public class ValidatorPersonName implements Validator<String>{
    @Override
    public void valide(String s) throws InvalidDataError {
        if (s.isBlank()|s.isEmpty()){
            throw new InvalidDataError();
        }
    }
}
