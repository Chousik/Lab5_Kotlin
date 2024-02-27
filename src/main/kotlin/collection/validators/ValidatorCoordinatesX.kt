package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError

/**
 * Валидатор координаты X
 */
class ValidatorCoordinatesX : IValidator<Float?> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param t число
     * @throws InvalidDataError     если число не соответствует диапазону
     * @throws NullPointerException если число null
     */
    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: Float?) {
        if (t!! <= -645) {
            throw InvalidDataError()
        }
    }
}