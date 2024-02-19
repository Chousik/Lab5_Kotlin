package org.example.collection.validators;

public class ValidatorLocationYZ implements Validator<Integer>{
    @Override
    public void valide(Integer integer) throws NullPointerException{
        if (integer == null){
            throw new NullPointerException();
        }
    }
}
