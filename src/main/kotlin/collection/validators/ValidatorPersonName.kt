package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError

/**
 * Валидатор имени человека
 */
class ValidatorPersonName : IValidator<String?> {
    /**
     * Проверяет строку на пустоту
     *
     * @param t строка
     * @throws InvalidDataError если строка пуста
     */
    @Throws(InvalidDataError::class)
    override fun valide(t: String?) {
        if (t!!.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}