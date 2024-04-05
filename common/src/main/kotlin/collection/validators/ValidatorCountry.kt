package collection.validators

import collection.Country

class ValidatorCountry : IValidator<String?> {
    override fun valid(t: String?) {
        Country.valueOf(t!!)
    }
}
