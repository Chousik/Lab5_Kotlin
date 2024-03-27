package org.chousik.collection.builder

import org.chousik.collection.Person
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.ValidatorPersonName
import org.chousik.collection.validators.ValidatorPersonPassportID


class BuilderPerson : IBuilder<Person?> {
    private val validatorPersonName: ValidatorPersonName = ValidatorPersonName()
    private val validatorPersonPassportID: ValidatorPersonPassportID = ValidatorPersonPassportID()
    private val builderColor: BuilderColor = BuilderColor()
    private val builderLocation: BuilderLocation = BuilderLocation()
    private val builderCountry: BuilderCountry = BuilderCountry()
    private val stringCollector = StringCollector()

    override fun build(): Person {
        return Person(
            stringCollector.ask("Имя Человека", validatorPersonName),
            stringCollector.ask("Паспорт айди", validatorPersonPassportID),
            builderColor.build(),
            builderCountry.build(),
            builderLocation.build()
        )
    }
}