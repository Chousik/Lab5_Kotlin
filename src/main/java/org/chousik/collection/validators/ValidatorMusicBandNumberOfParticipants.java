package org.chousik.collection.validators;

import org.chousik.exception.InvalidDataError;

/**
 * Валидатор количества участников музыкальной группы
 */
public class ValidatorMusicBandNumberOfParticipants implements IValidator<Long> {
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
