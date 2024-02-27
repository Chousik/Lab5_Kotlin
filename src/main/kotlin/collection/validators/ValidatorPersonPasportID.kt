package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError

/**
 * Валидатор номера паспорта человека
 */
class ValidatorPersonPasportID : IValidator<String?> {
    /**
     * Проверяет строку на пустоту
     *
     * @param s строка
     * @throws InvalidDataError если строка пуста или меньше 6 символов
     */
    @Throws(InvalidDataError::class)
    override fun valide(s: String?) {
        if (s!!.isEmpty() or (s.length < 6)) {
            throw InvalidDataError()
        }
    }
}