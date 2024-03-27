package org.chousik.collection.builder

import org.chousik.collection.Location
import org.chousik.collection.builder.collectors.DoubleCollector
import org.chousik.collection.builder.collectors.IntegerCollector
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.ValidatorLocationName
import org.chousik.collection.validators.ValidatorLocationX
import org.chousik.collection.validators.ValidatorLocationYZ

class BuilderLocation : IBuilder<Location> {
    private val validatorLocationName = ValidatorLocationName()
    private val validatorLocationX = ValidatorLocationX()
    private val validatorLocationYZ = ValidatorLocationYZ()
    private val doubleCollector = DoubleCollector()
    private val integerCollector = IntegerCollector()
    private val stringCollector = StringCollector()

    override fun build(): Location {
        return Location(
            doubleCollector.ask("Координата X", validatorLocationX),
            integerCollector.ask("Координата Y", validatorLocationYZ),
            integerCollector.ask("Координата Z", validatorLocationYZ),
            stringCollector.ask("Имя локации", validatorLocationName)
        )
    }
}