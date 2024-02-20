package org.example.collection.validators;

import org.example.collection.Country;
import org.example.exception.InvalidDataError;
/**
 * Валидатор страны
 */
public class ValidatorCountry implements Validator<String>{
    /**
     * Проверяет строку на соответствие стране
     * @param s строка
     * @throws InvalidDataError если строка не соответствует стране
     * @throws NullPointerException если строка null
     */
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException {
        try {
            Country.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
