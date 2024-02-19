package org.example.collection.validators;

import org.example.exception.InvalidDataError;

public interface Validator<T> {
    public void valide(T t) throws InvalidDataError;
}
