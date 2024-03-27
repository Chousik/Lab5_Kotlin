package collection.validators

import exeption.InvalidDataError


class ValidatorLocationName : IValidator<String?> {

    override fun valid(t: String?) {
        if (t == null) {
            return
        }
        if (t.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}