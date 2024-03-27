package collection.validators

import collection.MusicGenre


class ValidatorMusicGenre : IValidator<String?> {

    override fun valid(t: String?) {
        MusicGenre.valueOf(t!!)
    }
}