package org.example.collection.validators;

import org.example.exception.InvalidDataError;
/**
 * Интерфейс валидатор
 * @param <T> тип валидируемого объекта
 */
public interface Validator<T> {
    public void valide(T t) throws InvalidDataError;
}
