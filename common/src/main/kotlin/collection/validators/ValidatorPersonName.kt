package collection.validators

import exeption.InvalidDataError


class ValidatorPersonName : IValidator<String?> {

    override fun valid(t: String?) {
        if (t!!.isBlank() or t.isEmpty()) {
            throw InvalidDataError()
        }
    }
}