package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorCoordinatesX : IValidator<Float?> {
    override fun valide(t: Float?) {
        if (t == null){
            throw NullPointerException()
        }
        if (t <= -645) {
            throw InvalidDataError()
        }
    }
}