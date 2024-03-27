package collection.validators

import collection.Color


class ValidatorColor : IValidator<String?> {

    override fun valid(t: String?) {
        Color.valueOf(t!!)
    }
}