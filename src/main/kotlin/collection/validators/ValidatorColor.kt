package org.chousik.collection.validators

import org.chousik.collection.Color


class ValidatorColor : IValidator<String?> {

    override fun valide(t: String?) {
        Color.valueOf(t.toString())
    }
}