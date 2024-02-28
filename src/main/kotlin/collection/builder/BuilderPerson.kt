package org.chousik.collection.builder

import org.chousik.collection.Person
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.ValidatorPersonName
import org.chousik.collection.validators.ValidatorPersonPassportID


class BuilderPerson : IBuilder<Person?> {
    private val validatorPersonName: ValidatorPersonName = ValidatorPersonName()
    private val validatorPersonPasportID: ValidatorPersonPassportID = ValidatorPersonPassportID()
    private val BuilderColor: BuilderColor = BuilderColor()
    private val BuilderLocation: BuilderLocation = BuilderLocation()
    private val BuilderCountry: BuilderCountry = BuilderCountry()

    override fun build(): Person {
        return Person(
            StringCollector().ask("Имя Человека", validatorPersonName),
            StringCollector().ask("Паспорт айди", validatorPersonPasportID),
            BuilderColor.build(),
            BuilderCountry.build(),
            BuilderLocation.build()
        )
    }
}