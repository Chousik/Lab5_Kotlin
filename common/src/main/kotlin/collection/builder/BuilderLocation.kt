package collection.builder

import collection.Location
import collection.builder.collectors.DoubleCollector
import collection.builder.collectors.IntegerCollector
import collection.builder.collectors.StringCollector
import collection.validators.ValidatorLocationName
import collection.validators.ValidatorLocationX
import collection.validators.ValidatorLocationYZ
import scanners.MyScanners
import java.io.Serializable

class BuilderLocation(private val scanner: MyScanners) : IBuilder<Location>, Serializable {
    private val validatorLocationName = ValidatorLocationName()
    private val validatorLocationX = ValidatorLocationX()
    private val validatorLocationYZ = ValidatorLocationYZ()
    private val doubleCollector = DoubleCollector(scanner)
    private val integerCollector = IntegerCollector(scanner)
    private val stringCollector = StringCollector(scanner)

    override fun build(): Location {
        return Location(
            doubleCollector.ask("Координата X", validatorLocationX),
            integerCollector.ask("Координата Y", validatorLocationYZ),
            integerCollector.ask("Координата Z", validatorLocationYZ),
            stringCollector.ask("Имя локации", validatorLocationName),
        )
    }
}
