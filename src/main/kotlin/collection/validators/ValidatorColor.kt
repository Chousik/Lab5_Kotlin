package org.chousik.collection.validators

import org.chousik.collection.Color
import org.chousik.exception.InvalidDataError

/**
 * Валидатор цвета
 */
class ValidatorColor : IValidator<String?> {
    /**
     * Проверяет строку на соответствие цвету
     *
     * @param t строка
     * @throws InvalidDataError     если строка не соответствует цвету
     * @throws NullPointerException если строка null
     */
    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: String?) {
        try {
            Color.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}