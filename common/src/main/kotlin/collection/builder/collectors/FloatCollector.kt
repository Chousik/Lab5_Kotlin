package collection.builder.collectors

import collection.validators.IValidator
import scanners.MyScanners
import java.util.*

class FloatCollector(scanner: MyScanners) : NumberCollector<Float>(scanner) {
    override fun ask(name: String, validator: IValidator<Float?>): Float {
        return askNumber(name, validator, java.lang.Float::parseFloat)
    }
    }