package org.chousik.collection.validators

import org.chousik.collection.Country

class ValidatorCountry : IValidator<String?> {
    override fun valide(t: String?) {
        Country.valueOf(t.toString())
    }
}