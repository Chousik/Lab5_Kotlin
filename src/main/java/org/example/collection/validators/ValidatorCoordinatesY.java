package org.example.collection.validators;

public class ValidatorCoordinatesY implements Validator<Float>{
    @Override
    public void valide(Float aFloat) throws NullPointerException{
        if (aFloat == null){
            throw new NullPointerException();
        }
    }
}
