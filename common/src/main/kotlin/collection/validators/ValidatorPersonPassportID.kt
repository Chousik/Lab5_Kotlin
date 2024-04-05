package collection.validators

import exeption.InvalidDataError

const val CONST = 6

class ValidatorPersonPassportID : IValidator<String?> {
    override fun valid(t: String?) {
        if (t!!.isEmpty() or (t.length < CONST)) {
            throw InvalidDataError()
        }
    }
}
