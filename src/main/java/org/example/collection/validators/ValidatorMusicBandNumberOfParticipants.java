package org.example.collection.validators;

import org.example.exception.InvalidDataError;

public class ValidatorMusicBandNumberOfParticipants implements Validator<Long>{
    @Override
    public void valide(Long along) throws InvalidDataError {
        if (along == null){
            throw new NullPointerException();
        }
        if (along <= 0){
            throw new InvalidDataError();
        }
    }
}
