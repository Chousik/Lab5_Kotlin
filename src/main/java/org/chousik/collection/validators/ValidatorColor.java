package org.chousik.collection.validators;

import org.chousik.collection.Color;
import org.chousik.exception.InvalidDataError;

/**
 * Валидатор цвета
 */
public class ValidatorColor implements IValidator<String> {
    /**
     * Проверяет строку на соответствие цвету
     *
     * @param s строка
     * @throws InvalidDataError     если строка не соответствует цвету
     * @throws NullPointerException если строка null
     */
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException {
        try {
            Color.valueOf(s);
        } catch (IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
