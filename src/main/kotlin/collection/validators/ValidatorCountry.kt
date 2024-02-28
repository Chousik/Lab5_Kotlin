package org.chousik.collection.validators

import org.chousik.collection.Country
import org.chousik.exception.InvalidDataError


class ValidatorCountry : IValidator<String?> {
    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: String?) {
        try {
            Country.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}