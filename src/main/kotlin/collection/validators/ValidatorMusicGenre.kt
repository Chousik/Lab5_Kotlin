package org.chousik.collection.validators

import org.chousik.collection.MusicGenre
import org.chousik.exception.InvalidDataError


class ValidatorMusicGenre : IValidator<String?> {

    override fun valide(t: String?) {
        try {
            MusicGenre.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}