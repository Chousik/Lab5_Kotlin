package org.chousik.collection.validators


class ValidatorLocationYZ : IValidator<Int?> {

    override fun valid(t: Int?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}