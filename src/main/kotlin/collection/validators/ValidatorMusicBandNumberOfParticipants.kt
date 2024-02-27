package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError

/**
 * Валидатор количества участников музыкальной группы
 */
class ValidatorMusicBandNumberOfParticipants : IValidator<Long?> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param t число
     * @throws InvalidDataError     если число не соответствует диапазону
     * @throws NullPointerException если число null
     */
    @Throws(InvalidDataError::class)
    override fun valide(t: Long?) {
        if (t == null) {
            throw NullPointerException()
        }
        if (t <= 0) {
            throw InvalidDataError()
        }
    }
}