package org.chousik.collection.validators

import org.chousik.collection.MusicGenre
import org.chousik.exception.InvalidDataError


class ValidatorMusicGenre : IValidator<String?> {

    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: String?) {
        try {
            MusicGenre.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}