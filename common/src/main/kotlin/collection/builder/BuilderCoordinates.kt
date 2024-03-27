package collection.builder

import collection.builder.collectors.FloatCollector
import collection.validators.ValidatorCoordinatesX
import collection.validators.ValidatorCoordinatesY
import collection.Coordinates
import scanners.MyScanners
import java.io.Serializable
import java.util.*


class BuilderCoordinates(private val scanner: MyScanners) : IBuilder<Coordinates>, Serializable {
    private val validatorCoordinatesX = ValidatorCoordinatesX()
    private val validatorCoordinatesY = ValidatorCoordinatesY()
    private val floatCollector = FloatCollector(scanner)

    override fun build(): Coordinates {
        return Coordinates(
            floatCollector.ask("Координата X", validatorCoordinatesX),
            floatCollector.ask("Координата Y", validatorCoordinatesY)
        )
    }
}