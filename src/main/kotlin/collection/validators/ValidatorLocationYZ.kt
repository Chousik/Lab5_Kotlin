package org.chousik.collection.validators


class ValidatorLocationYZ : IValidator<Int?> {

    @Throws(NullPointerException::class)
    override fun valide(t: Int?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}