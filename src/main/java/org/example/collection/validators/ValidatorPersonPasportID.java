package org.example.collection.validators;

import org.example.exception.NotValidData;

public class ValidatorPersonPasportID implements Validator<String> {
    @Override
    public void valide(String s) throws NotValidData {
        if (s.isEmpty() | s.length()<6){
            throw  new NotValidData();
        }
    }
}
