package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


class ValidatorPersonName : IValidator<String?> {

    override fun valide(t: String?) {
        if (t!!.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}