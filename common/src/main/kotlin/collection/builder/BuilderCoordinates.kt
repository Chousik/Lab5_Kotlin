package collection.builder

import collection.Coordinates
import collection.builder.collectors.FloatCollector
import collection.validators.ValidatorCoordinatesX
import collection.validators.ValidatorCoordinatesY
import scanners.MyScanners
import java.io.Serializable

class BuilderCoordinates(scanner: MyScanners) : IBuilder<Coordinates>, Serializable {
    private val validatorCoordinatesX = ValidatorCoordinatesX()
    private val validatorCoordinatesY = ValidatorCoordinatesY()
    private val floatCollector = FloatCollector(scanner)

    override fun build(): Coordinates {
        return Coordinates(
            floatCollector.ask("Координата X", validatorCoordinatesX),
            floatCollector.ask("Координата Y", validatorCoordinatesY),
        )
    }
}
