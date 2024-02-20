package org.chousik.collection.validators;

import org.chousik.exception.InvalidDataError;

/**
 * Интерфейс валидатор
 *
 * @param <T> тип валидируемого объекта
 */
public interface Validator<T> {
    public void valide(T t) throws InvalidDataError;
}
