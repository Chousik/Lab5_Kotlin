package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorMusicBandAlbumsCount : IValidator<Long?> {

    override fun valide(t: Long?) {
        if (t == null) {
            throw NullPointerException()
        }
        if (t <= 0) {
            throw InvalidDataError()
        }
    }
}