package org.chousik.collection.validators

import org.chousik.collection.Color


class ValidatorColor : IValidator<String?> {

    override fun valid(t: String?) {
        Color.valueOf(t!!)
    }
}