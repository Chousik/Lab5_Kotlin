package org.chousik.collection.builder.collectors

import org.chousik.collection.Color
import org.chousik.collection.validators.IValidator
class ColorCollector : EnumCollector<Color>() {

    override fun ask(name: String, validator: IValidator<String?>): Color {
        return askEnum(
            name, validator,
            { value: String -> Color.valueOf(value) }, Color.value
        )
    }
}