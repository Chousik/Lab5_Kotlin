package org.chousik.collection.builder

import org.chousik.collection.MusicGenre
import org.chousik.collection.builder.collectors.MusicGenreCollector
import org.chousik.collection.validators.IValidator
import org.chousik.collection.validators.ValidatorMusicGenre
import org.chousik.exception.ScriptExecutionError

/**
 * Класс строитель для создания объекта класса MusicGenre
 */
class BuilderMusicGenre : IBuilder<MusicGenre?> {
    private val validatorMusicGenre: ValidatorMusicGenre = ValidatorMusicGenre()

    @Throws(ScriptExecutionError::class)
    override fun build(): MusicGenre? {
        return MusicGenreCollector().ask("Жанр музыки", validatorMusicGenre)
    }
}