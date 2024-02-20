package org.example.collection.validators;

import org.example.collection.Color;
import org.example.exception.InvalidDataError;
/**
 * Валидатор цвета
 */
public class ValidatorColor implements Validator<String>{
    /**
     * Проверяет строку на соответствие цвету
     * @param s строка
     * @throws InvalidDataError если строка не соответствует цвету
     * @throws NullPointerException если строка null
     */
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException{
        try {
            Color.valueOf(s);
        }
        catch(IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
