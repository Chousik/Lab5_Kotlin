package org.chousik.collection.builder

import org.chousik.collection.Country
import org.chousik.collection.builder.collectors.CountryCollector
import org.chousik.collection.validators.IValidator
import org.chousik.collection.validators.ValidatorCountry
import org.chousik.exception.ScriptExecutionError


class BuilderCountry : IBuilder<Country?> {
    private val validatorCountry: ValidatorCountry = ValidatorCountry()


    override fun build(): Country? {
        return CountryCollector().ask("Страна", validatorCountry)
    }
}