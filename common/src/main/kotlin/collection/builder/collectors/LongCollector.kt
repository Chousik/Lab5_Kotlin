package collection.builder.collectors

import collection.validators.IValidator
import scanners.MyScanners

class LongCollector(scanner: MyScanners) : NumberCollector<Long>(scanner) {
    override fun ask(
        name: String,
        validator: IValidator<Long?>,
    ): Long {
        return askNumber(name, validator, java.lang.Long::parseLong)
    }
}
