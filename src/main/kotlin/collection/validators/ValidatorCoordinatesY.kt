package org.chousik.collection.validators


class ValidatorCoordinatesY : IValidator<Float?> {

    override fun valide(t: Float?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}