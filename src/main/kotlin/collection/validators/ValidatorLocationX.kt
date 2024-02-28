package org.chousik.collection.validators


class ValidatorLocationX : IValidator<Double?> {

    @Throws(NullPointerException::class)
    override fun valide(t: Double?) {
        if ((t == null) or t!!.isNaN()) {
            throw NullPointerException()
        }
    }
}