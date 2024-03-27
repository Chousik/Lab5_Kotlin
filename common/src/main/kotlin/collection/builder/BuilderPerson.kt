package collection.builder

import collection.Person
import collection.builder.collectors.StringCollector
import collection.validators.ValidatorPersonName
import collection.validators.ValidatorPersonPassportID
import scanners.MyScanners
import java.io.Serializable
import java.util.*


class BuilderPerson(private val scanner: MyScanners) : IBuilder<Person?>, Serializable {
    private val validatorPersonName: ValidatorPersonName = ValidatorPersonName()
    private val validatorPersonPassportID: ValidatorPersonPassportID = ValidatorPersonPassportID()
    private val builderColor: BuilderColor = BuilderColor(scanner)
    private val builderLocation: BuilderLocation = BuilderLocation(scanner)
    private val builderCountry: BuilderCountry = BuilderCountry(scanner)
    private val stringCollector = StringCollector(scanner)

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