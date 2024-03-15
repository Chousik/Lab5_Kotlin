package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorMusicBandNumberOfParticipants : IValidator<Long?> {

    override fun valid(t: Long?) {
        if (t == null) {
            throw NullPointerException()
        }
        if (t <= 0) {
            throw InvalidDataError()
        }
    }
}