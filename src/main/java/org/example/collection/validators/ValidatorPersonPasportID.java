package org.example.collection.validators;

import org.example.exception.InvalidDataError;
/**
 * Валидатор номера паспорта человека
 */

public class ValidatorPersonPasportID implements Validator<String> {
    /**
     * Проверяет строку на пустоту
     * @param s строка
     * @throws InvalidDataError если строка пуста или меньше 6 символов
     */
    @Override
    public void valide(String s) throws InvalidDataError {
        if (s.isEmpty() | s.length()<6){
            throw  new InvalidDataError();
        }
    }
}
