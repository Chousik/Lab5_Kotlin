package org.example.collection.validators;

import org.example.exception.NotValidData;

public class ValidatorPersonName implements Validator<String>{
    @Override
    public void valide(String s) throws NotValidData {
        if (s.isBlank()|s.isEmpty()){
            throw new NotValidData();
        }
    }
}
