package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorPersonPassportID : IValidator<String?> {
    private val const = 6;
    override fun valide(t: String?) {
        if (t!!.isEmpty() or (t.length < const)) {
            throw InvalidDataError()
        }
    }
}