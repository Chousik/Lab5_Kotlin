package org.chousik.collection.validators

import org.chousik.collection.Country

class ValidatorCountry : IValidator<String?> {
    override fun valid(t: String?) {
        Country.valueOf(t!!)
    }
}