package org.example.collection.validators;

import org.example.exception.NotValidData;

public class ValidatorCoordinatesX implements Validator<Float>{
    @Override
    public void valide(Float aFloat) throws NotValidData, NullPointerException{
        if (aFloat == null){
            throw new NullPointerException();
        }
        if (aFloat <= -645 ){
            throw new NotValidData();
        }
    }
}
