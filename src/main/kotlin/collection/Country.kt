package org.chousik.collection

import java.util.*
import java.util.stream.Collectors

enum class Country {
    RUSSIA,
    UNITED_KINGDOM,
    GERMANY,
    VATICAN;

    companion object {
        val value: String
            get() = Arrays.stream(entries.toTypedArray())
                .map { obj: Country -> obj.name }
                .collect(Collectors.joining(", "))
    }
}