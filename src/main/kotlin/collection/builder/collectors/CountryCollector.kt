package org.chousik.collection.builder.collectors

import org.chousik.collection.Country
import org.chousik.collection.MusicGenre
import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError
import java.util.function.Function
class CountryCollector : EnumCollector<Country?>() {

    override fun ask(name: String?, validator: IValidator<String?>?): Country? {
        return askEnum(
            name!!, validator!!,
            Function { value: String? -> Country.valueOf(value!!) }, Country.value
        )!!
    }
}