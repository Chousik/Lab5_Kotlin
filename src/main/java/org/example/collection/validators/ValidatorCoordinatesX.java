package org.example.collection.validators;

import org.example.exception.InvalidDataError;

public class ValidatorCoordinatesX implements Validator<Float>{
    @Override
    public void valide(Float aFloat) throws InvalidDataError, NullPointerException{
        if (aFloat == null){
            throw new NullPointerException();
        }
        if (aFloat <= -645 ){
            throw new InvalidDataError();
        }
    }
}
