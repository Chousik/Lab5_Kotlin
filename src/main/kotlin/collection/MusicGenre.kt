package org.chousik.collection

import java.util.*
import java.util.stream.Collectors


enum class MusicGenre {
    JAZZ,
    SOUL,
    POP;

    companion object {
        val value: String

            get() = Arrays.stream(entries.toTypedArray())
                .map({ obj: MusicGenre -> obj.name })
                .collect(Collectors.joining(", "))
    }
}