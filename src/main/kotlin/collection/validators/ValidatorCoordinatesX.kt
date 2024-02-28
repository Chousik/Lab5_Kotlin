package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


class ValidatorCoordinatesX : IValidator<Float?> {
    @Throws(InvalidDataError::class, NullPointerException::class)
    override fun valide(t: Float?) {
        if (t!! <= -645) {
            throw InvalidDataError()
        }
    }
}