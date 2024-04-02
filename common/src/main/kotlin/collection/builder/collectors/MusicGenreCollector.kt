package collection.builder.collectors

import collection.MusicGenre
import collection.validators.IValidator
import scanners.MyScanners

class MusicGenreCollector(private val scanner: MyScanners) : EnumCollector<MusicGenre>(scanner) {
    override fun ask(name: String, validator: IValidator<String?>): MusicGenre? {
        return askEnum(
            name, validator,
            { value: String -> MusicGenre.valueOf(value) }, MusicGenre.value
        )
    }
}