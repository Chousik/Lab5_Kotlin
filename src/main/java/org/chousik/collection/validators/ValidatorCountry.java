package org.chousik.collection.validators;

import org.chousik.collection.Country;
import org.chousik.exception.InvalidDataError;

/**
 * Валидатор страны
 */
public class ValidatorCountry implements IValidator<String> {
    /**
     * Проверяет строку на соответствие стране
     *
     * @param s строка
     * @throws InvalidDataError     если строка не соответствует стране
     * @throws NullPointerException если строка null
     */
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException {
        try {
            Country.valueOf(s);
        } catch (IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
