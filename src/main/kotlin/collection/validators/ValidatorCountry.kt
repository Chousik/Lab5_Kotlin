package org.chousik.collection.validators

import org.chousik.collection.Country
import exeption.InvalidDataError


class ValidatorCountry : IValidator<String?> {
    override fun valide(t: String?) {
        try {
            Country.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}