package org.example.collection.validators;

import org.example.exception.InvalidDataError;

public class ValidatorPersonPasportID implements Validator<String> {
    @Override
    public void valide(String s) throws InvalidDataError {
        if (s.isEmpty() | s.length()<6){
            throw  new InvalidDataError();
        }
    }
}
