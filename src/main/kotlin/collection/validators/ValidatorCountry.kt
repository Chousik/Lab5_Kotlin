package org.chousik.collection.validators

import org.chousik.collection.Country
import org.chousik.exception.InvalidDataError

/**
 * Валидатор страны
 */
class ValidatorCountry : IValidator<String?> {
    /**
     * Проверяет строку на соответствие стране
     *
     * @param t строка
     * @throws InvalidDataError     если строка не соответствует стране
     * @throws NullPointerException если строка null
     */
    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: String?) {
        try {
            Country.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}