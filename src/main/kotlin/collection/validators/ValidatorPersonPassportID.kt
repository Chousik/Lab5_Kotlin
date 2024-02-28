package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorPersonPassportID : IValidator<String?> {

    override fun valide(t: String?) {
        if (t!!.isEmpty() or (t.length < 6)) {
            throw InvalidDataError()
        }
    }
}