package org.example.collection.validators;

import org.example.exception.InvalidDataError;

/**
 * Валидатор имени человека
 */

public class ValidatorPersonName implements Validator<String> {
    /**
     * Проверяет строку на пустоту
     *
     * @param s строка
     * @throws InvalidDataError если строка пуста
     */
    @Override
    public void valide(String s) throws InvalidDataError {
        if (s.isBlank() | s.isEmpty()) {
            throw new InvalidDataError();
        }
    }
}
