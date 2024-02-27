package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError

/**
 * Валидатор названия локации
 */
class ValidatorLocationName : IValidator<String?> {
    /**
     * Проверяет строку на пустоту
     *
     * @param t строка
     * @throws InvalidDataError если строка пуста
     */
    @Throws(InvalidDataError::class)
    override fun valide(t: String?) {
        if (t == null) {
            return
        }
        if (t.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}