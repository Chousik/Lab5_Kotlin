package org.chousik.collection.validators


class ValidatorLocationX : IValidator<Double?> {

    override fun valid(t: Double?) {
        if ((t == null) or t!!.isNaN()) {
            throw NullPointerException()
        }
    }
}