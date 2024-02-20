package org.example.collection.validators;

import org.example.exception.InvalidDataError;

/**
 * Валидатор количества альбомов музыкальной группы
 */
public class ValidatorMusicBandAlbumsCount implements Validator<Long> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param along число
     * @throws InvalidDataError     если число не соответствует диапазону
     * @throws NullPointerException если число null
     */
    @Override
    public void valide(Long along) throws InvalidDataError {
        if (along == null) {
            throw new NullPointerException();
        }
        if (along <= 0) {
            throw new InvalidDataError();
        }
    }
}
