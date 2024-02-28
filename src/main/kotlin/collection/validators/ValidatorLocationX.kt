package org.chousik.collection.validators


class ValidatorLocationX : IValidator<Double?> {

    override fun valide(t: Double?) {
        if ((t == null) or t!!.isNaN()) {
            throw NullPointerException()
        }
    }
}