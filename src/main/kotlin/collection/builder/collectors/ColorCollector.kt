package org.chousik.collection.builder.collectors

import org.chousik.collection.Color
import org.chousik.collection.Country
import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError
import java.util.function.Function
class ColorCollector : EnumCollector<Color?>() {
    @Throws(ScriptExecutionError::class)
    override fun ask(name: String?, validator: IValidator<String?>?): Color? {
        return askEnum(
            name!!, validator!!,
            Function { value: String? -> Color.valueOf(value!!) }, Color.value
        )!!
    }
}