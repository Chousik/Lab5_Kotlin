package collection.builder.collectors

import collection.Country
import collection.validators.IValidator
import scanners.MyScanners
import java.util.*

class CountryCollector(scanner: MyScanners) : EnumCollector<Country>(scanner) {

    override fun ask(name: String, validator: IValidator<String?>): Country {
        return askEnum(
            name, validator,
            { value: String -> Country.valueOf(value) }, Country.value
        )
    }
}