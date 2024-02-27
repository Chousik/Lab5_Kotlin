package org.chousik.collection

import java.util.*
import java.util.stream.Collectors

/**
 * Класс перечисление жанров музыки
 */
enum class MusicGenre {
    JAZZ,
    SOUL,
    POP;

    companion object {
        val value: String
            /**
             * @return возвращает все значения перечисления
             */
            get() = Arrays.stream(entries.toTypedArray())
                .map({ obj: MusicGenre -> obj.name })
                .collect(Collectors.joining(", "))
    }
}