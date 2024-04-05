package collection

import java.io.Serializable
import java.util.Arrays
import java.util.stream.Collectors

enum class Country : Serializable {
    RUSSIA,
    UNITED_KINGDOM,
    GERMANY,
    VATICAN,
    ;

    companion object {
        val value: String
            get() =
                Arrays.stream(entries.toTypedArray())
                    .map { obj: Country -> obj.name }
                    .collect(Collectors.joining(", "))
    }
}
