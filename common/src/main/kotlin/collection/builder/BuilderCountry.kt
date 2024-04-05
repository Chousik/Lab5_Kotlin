package collection.builder

import collection.Country
import collection.builder.collectors.CountryCollector
import collection.validators.ValidatorCountry
import scanners.MyScanners
import java.io.Serializable

class BuilderCountry(private val scanner: MyScanners) : IBuilder<Country>, Serializable {
    private val validatorCountry = ValidatorCountry()
    private val countryCollector = CountryCollector(scanner)

    override fun build(): Country? {
        return countryCollector.ask("Страна", validatorCountry)
    }
}
