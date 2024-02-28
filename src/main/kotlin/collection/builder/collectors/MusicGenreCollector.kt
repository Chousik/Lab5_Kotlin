package org.chousik.collection.builder.collectors

import org.chousik.collection.MusicGenre
import org.chousik.collection.validators.IValidator
import java.util.function.Function

class MusicGenreCollector : EnumCollector<MusicGenre>() {
    override fun ask(name: String, validator: IValidator<String?>): MusicGenre {
        return askEnum(
            name, validator,
            { value: String -> MusicGenre.valueOf(value) }, MusicGenre.value
        )
    }
}