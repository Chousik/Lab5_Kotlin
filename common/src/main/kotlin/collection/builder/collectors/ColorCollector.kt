package collection.builder.collectors

import collection.Color
import collection.validators.IValidator
import scanners.MyScanners

class ColorCollector(scanner: MyScanners) : EnumCollector<Color>(scanner) {
    override fun ask(
        name: String,
        validator: IValidator<String?>,
    ): Color? {
        return askEnum(
            name,
            validator,
            { value: String -> Color.valueOf(value) },
            Color.value,
        )
    }
}
