package org.chousik.collection.validators

import org.chousik.collection.Color
import org.chousik.exception.InvalidDataError


class ValidatorColor : IValidator<String?> {

    override fun valide(t: String?) {
        try {
            Color.valueOf(t.toString())
        } catch (ex: IllegalArgumentException) {
            throw InvalidDataError()
        }
    }
}