package org.chousik.collection.validators

import exeption.InvalidDataError


class ValidatorCoordinatesX : IValidator<Float?> {
    private val const = -645
    override fun valide(t: Float?) {
        if (t == null){
            throw NullPointerException()
        }
        if (t <= const) {
            throw InvalidDataError()
        }
    }
}