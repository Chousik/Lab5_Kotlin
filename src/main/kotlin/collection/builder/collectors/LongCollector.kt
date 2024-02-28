package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError

class LongCollector : NumberCollector<Long?>() {
    override fun ask(name: String?, validator: IValidator<Long?>?): Long? {
        return askNumber(name!!, validator!!, java.lang.Long::parseLong)
    }
}