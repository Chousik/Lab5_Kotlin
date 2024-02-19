package org.example.collection.validators;

import org.example.exception.NotValidData;

public class ValidatorMusicBandAlbumsCount implements Validator<Long>{
    @Override
    public void valide(Long along) throws NotValidData {
        if (along == null){
            throw new NullPointerException();
        }
        if (along <= 0){
            throw new NotValidData();
        }
    }
}
