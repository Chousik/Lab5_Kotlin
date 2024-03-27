package org.chousik.collection.validators

import org.chousik.collection.MusicGenre


class ValidatorMusicGenre : IValidator<String?> {

    override fun valid(t: String?) {
        MusicGenre.valueOf(t!!)
    }
}