package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


class ValidatorLocationName : IValidator<String?> {

    override fun valide(t: String?) {
        if (t == null) {
            return
        }
        if (t.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}