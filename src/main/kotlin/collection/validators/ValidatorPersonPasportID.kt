package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorPersonPasportID : IValidator<String?> {

    override fun valide(s: String?) {
        if (s!!.isEmpty() or (s.length < 6)) {
            throw InvalidDataError()
        }
    }
}