package collection.builder.collectors

import collection.validators.IValidator
import scanners.MyScanners
import java.util.*

class DoubleCollector(scanner: MyScanners) : NumberCollector<Double>(scanner) {

    override fun ask(name: String, validator: IValidator<Double?>): Double {
        return askNumber(name, validator, java.lang.Double::parseDouble)
    }
}