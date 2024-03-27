package collection.builder

import collection.MusicGenre
import collection.builder.collectors.MusicGenreCollector
import collection.validators.ValidatorMusicGenre
import scanners.MyScanners
import java.io.Serializable
import java.util.*


class BuilderMusicGenre(private val scanner: MyScanners) : IBuilder<MusicGenre>, Serializable {
    private val validatorMusicGenre: ValidatorMusicGenre = ValidatorMusicGenre()

    override fun build(): MusicGenre {
        return MusicGenreCollector(scanner).ask("Жанр музыки", validatorMusicGenre)
    }
}