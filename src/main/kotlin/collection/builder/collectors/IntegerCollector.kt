package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError

class IntegerCollector : NumberCollector<Int?>() {
    @Throws(ScriptExecutionError::class)
    override fun ask(name: String?, validator: IValidator<Int?>?): Int? {
        return askNumber(name!!, validator!!,  Integer::parseInt)
    }
}