package org.example.collection.validators;

public class ValidatorLocationX implements Validator<Double>{
    @Override
    public void valide(Double aDouble) throws NullPointerException{
        if (aDouble == null | aDouble.isNaN()){
            throw new NullPointerException();
        }
    }
}
