package org.chousik.collection.validators;

import org.chousik.exception.InvalidDataError;

/**
 * Валидатор названия локации
 */
public class ValidatorLocationName implements Validator<String> {
    /**
     * Проверяет строку на пустоту
     *
     * @param s строка
     * @throws InvalidDataError если строка пуста
     */
    @Override
    public void valide(String s) throws InvalidDataError {
        if (s == null) {
            return;
        }
        if (s.isBlank() | s.isEmpty()) {
            throw new InvalidDataError();
        }
    }
}
