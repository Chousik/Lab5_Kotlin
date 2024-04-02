package collection.builder.collectors

import collection.validators.IValidator
import scanners.MyScanners

class FloatCollector(scanner: MyScanners) : NumberCollector<Float>(scanner) {
    override fun ask(name: String, validator: IValidator<Float?>): Float {
        return askNumber(name, validator, java.lang.Float::parseFloat)
    }
    }