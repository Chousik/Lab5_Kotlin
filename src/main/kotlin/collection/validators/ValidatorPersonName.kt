package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


class ValidatorPersonName : IValidator<String?> {

    @Throws(InvalidDataError::class)
    override fun valide(t: String?) {
        if (t!!.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}