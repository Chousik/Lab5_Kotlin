package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator

class IntegerCollector : NumberCollector<Int?>() {

    override fun ask(name: String?, validator: IValidator<Int?>?): Int? {
        return askNumber(name!!, validator!!,  Integer::parseInt)
    }
}