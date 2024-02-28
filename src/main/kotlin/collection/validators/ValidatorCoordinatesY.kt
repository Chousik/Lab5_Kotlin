package org.chousik.collection.validators


class ValidatorCoordinatesY : IValidator<Float?> {

    @Throws(NullPointerException::class)
    override fun valide(t: Float?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}