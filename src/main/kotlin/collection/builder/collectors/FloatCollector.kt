package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator

class FloatCollector : NumberCollector<Float>() {
    override fun ask(name: String, validator: IValidator<Float?>): Float {
        return askNumber(name, validator, java.lang.Float::parseFloat)
    }
    }