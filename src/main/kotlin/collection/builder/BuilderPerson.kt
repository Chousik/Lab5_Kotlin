package org.chousik.collection.builder

import org.chousik.collection.Person
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.IValidator
import org.chousik.collection.validators.ValidatorPersonName
import org.chousik.collection.validators.ValidatorPersonPasportID
import org.chousik.exception.ScriptExecutionError

/**
 * Класс строитель для создания объекта класса Person
 */
class BuilderPerson : IBuilder<Person?> {
    private val validatorPersonName: IValidator<String> = ValidatorPersonName()
    private val validatorPersonPasportID: IValidator<String> = ValidatorPersonPasportID()
    private val BuilderColor: BuilderColor = BuilderColor()
    private val BuilderLocation: BuilderLocation = BuilderLocation()
    private val BuilderCountry: BuilderCountry = BuilderCountry()

    /**
     * Метод для создания объекта класса Person
     *
     * @return возвращает объект класса Person
     */
    @Throws(ScriptExecutionError::class)
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