package org.chousik.collection.builder

import org.chousik.collection.builder.collectors.FloatCollector
import org.chousik.collection.validators.ValidatorCoordinatesX
import org.chousik.collection.validators.ValidatorCoordinatesY
import org.chousik.collection.Coordinates


class BuilderCoordinates : IBuilder<Coordinates> {
    private val validatorCoordinatesX = ValidatorCoordinatesX()
    private val validatorCoordinatesY = ValidatorCoordinatesY()
    private val floatCollector = FloatCollector()

    override fun build(): Coordinates {
        return Coordinates(
            floatCollector.ask("Координата X", validatorCoordinatesX),
            floatCollector.ask("Координата Y", validatorCoordinatesY)
        )
    }
}