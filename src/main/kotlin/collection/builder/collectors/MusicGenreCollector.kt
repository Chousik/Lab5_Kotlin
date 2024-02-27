package org.chousik.collection.builder.collectors

import org.chousik.collection.MusicGenre
import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError
import java.util.function.Function
import java.util.function.Supplier

class MusicGenreCollector : EnumCollector<MusicGenre?>() {
    @Throws(ScriptExecutionError::class)
    override fun ask(name: String?, validator: IValidator<String?>?): MusicGenre? {
        return askEnum(
            name!!, validator!!,
            Function { value: String? -> MusicGenre.valueOf(value!!) }, MusicGenre.value
        )!!
    }
}