package org.example.collection.validators;

import org.example.exception.NotValidData;

public class ValidatorLocationName implements Validator<String>{
    @Override
    public void valide(String s) throws NotValidData {
        if (s == null) {
            return;
        }
        if (s.isBlank()|s.isEmpty()){
            throw new NotValidData();
        }
    }
}
