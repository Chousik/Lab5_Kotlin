package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorMusicBandName : IValidator<String?> {

    override fun valide(t: String?) {
        if (t!!.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}