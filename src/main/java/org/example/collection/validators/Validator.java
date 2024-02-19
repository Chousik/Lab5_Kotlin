package org.example.collection.validators;

import org.example.exception.NotValidData;

public interface Validator<T> {
    public void valide(T t) throws NotValidData;
}
