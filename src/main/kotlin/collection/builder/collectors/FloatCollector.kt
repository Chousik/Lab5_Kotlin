package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError

class FloatCollector : NumberCollector<Float?>() {
    @Throws(ScriptExecutionError::class)
    override fun ask(name: String?, validator: IValidator<Float?>?): Float? {
        return askNumber(name!!, validator!!, java.lang.Float::parseFloat)
    }
    }