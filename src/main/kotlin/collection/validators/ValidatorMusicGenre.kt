package org.chousik.collection.validators

import org.chousik.collection.MusicGenre
import org.chousik.exception.InvalidDataError

/**
 * Валидатор жанра музыки
 */
class ValidatorMusicGenre : IValidator<String?> {
    /**
     * Проверяет строку на соответствие жанру музыки
     *
     * @param t строка
     * @throws InvalidDataError     если строка не соответствует жанру музыки
     * @throws NullPointerException если строка null
     */
    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: String?) {
        try {
            MusicGenre.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}