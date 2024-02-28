package org.chousik.collection.validators


class ValidatorLocationYZ : IValidator<Int?> {

    override fun valide(t: Int?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}