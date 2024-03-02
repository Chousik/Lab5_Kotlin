package org.chousik.collection.validators

import org.chousik.collection.MusicGenre


class ValidatorMusicGenre : IValidator<String?> {

    override fun valide(t: String?) {
        MusicGenre.valueOf(t.toString())
    }
}