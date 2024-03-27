package org.chousik.collection.builder

import org.chousik.collection.Country
import org.chousik.collection.builder.collectors.CountryCollector
import org.chousik.collection.validators.ValidatorCountry


class BuilderCountry : IBuilder<Country> {
    private val validatorCountry = ValidatorCountry()
    private val countryCollector = CountryCollector()

    override fun build(): Country {
        return countryCollector.ask("Страна", validatorCountry)
    }
}