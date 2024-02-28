package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorCoordinatesX : IValidator<Float?> {
    override fun valide(t: Float?) {
        if (t!! <= -645) {
            throw InvalidDataError()
        }
    }
}