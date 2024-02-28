package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator

class DoubleCollector : NumberCollector<Double>() {

    override fun ask(name: String, validator: IValidator<Double>): Double {
        return askNumber(name, validator, java.lang.Double::parseDouble)
    }
}