package org.chousik.collection

import java.util.*
import java.util.stream.Collectors

/**
 * Класс перечисление цветов
 */
enum class Color {
    GREEN,
    YELLOW,
    ORANGE,
    BROWN;

    companion object {
        val value: String
            /**
             * @return возвращает все значения перечисления
             */
            get() = Arrays.stream(entries.toTypedArray())
                .map({ obj: Color -> obj.name })
                .collect(Collectors.joining(", "))
    }
}