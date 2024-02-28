package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError

class DoubleCollector : NumberCollector<Double?>() {

    override fun ask(name: String?, validator: IValidator<Double?>?): Double? {
        return askNumber(name!!, validator!!, java.lang.Double::parseDouble)
    }
}