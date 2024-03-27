package collection.builder.collectors

import collection.validators.IValidator
import scanners.MyScanners
import java.util.*

class IntegerCollector(private val scanner: MyScanners) : NumberCollector<Int>(scanner) {
    override fun ask(name: String, validator: IValidator<Int?>): Int {
        return askNumber(name, validator,  Integer::parseInt)
    }
}