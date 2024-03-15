package org.chousik.collection.builder.collectors

import org.chousik.collection.Country
import org.chousik.collection.validators.IValidator
class CountryCollector : EnumCollector<Country>() {

    override fun ask(name: String, validator: IValidator<String?>): Country {
        return askEnum(
            name, validator,
            { value: String -> Country.valueOf(value) }, Country.value
        )
    }
}