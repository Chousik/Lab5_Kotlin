package org.chousik.collection.builder

import org.chousik.collection.builder.collectors.FloatCollector
import org.chousik.collection.validators.IValidator
import org.chousik.collection.validators.ValidatorCoordinatesX
import org.chousik.collection.validators.ValidatorCoordinatesY
import org.chousik.collection.Сoordinates
import org.chousik.exception.ScriptExecutionError


class BuilderCoordinates : IBuilder<Сoordinates?> {
    private val validatorCoordinatesX: ValidatorCoordinatesX = ValidatorCoordinatesX()
    private val validatorCoordinatesY: ValidatorCoordinatesY = ValidatorCoordinatesY()

    @Throws(ScriptExecutionError::class)
    override fun build(): Сoordinates {
        return Сoordinates(
            FloatCollector().ask("Координата X", validatorCoordinatesX),
            FloatCollector().ask("Координата Y", validatorCoordinatesY)!!
        )
    }
}