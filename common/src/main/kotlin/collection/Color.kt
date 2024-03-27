package collection

import java.io.Serializable
import java.util.*
import java.util.stream.Collectors


enum class Color: Serializable {
    GREEN,
    YELLOW,
    ORANGE,
    BROWN;

    companion object {
        val value: String
            get() = Arrays.stream(entries.toTypedArray())
                .map { obj: Color -> obj.name }
                .collect(Collectors.joining(", "))
    }
}
