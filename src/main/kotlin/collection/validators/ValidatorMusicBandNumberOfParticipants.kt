package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


class ValidatorMusicBandNumberOfParticipants : IValidator<Long?> {

    @Throws(InvalidDataError::class)
    override fun valide(t: Long?) {
        if (t == null) {
            throw NullPointerException()
        }
        if (t <= 0) {
            throw InvalidDataError()
        }
    }
}