package org.chousik.collection.builder

import org.chousik.collection.Location
import org.chousik.collection.builder.collectors.DoubleCollector
import org.chousik.collection.builder.collectors.IntegerCollector
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.ValidatorLocationName
import org.chousik.collection.validators.ValidatorLocationX
import org.chousik.collection.validators.ValidatorLocationYZ

class BuilderLocation : IBuilder<Location?> {
    private val validatorLocationName: ValidatorLocationName = ValidatorLocationName()
    private val validatorLocationX: ValidatorLocationX = ValidatorLocationX()
    private val validatorLocationYZ: ValidatorLocationYZ = ValidatorLocationYZ()

    override fun build(): Location {
        return Location(
            DoubleCollector().ask("Координата X", validatorLocationX),
            IntegerCollector().ask("Координата Y", validatorLocationYZ),
            IntegerCollector().ask("Координата Z", validatorLocationYZ),
            StringCollector().ask("Имя локации", validatorLocationName)
        )
    }
}