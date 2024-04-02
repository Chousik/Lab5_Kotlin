package collection.builder

import collection.Color
import collection.builder.collectors.ColorCollector
import collection.validators.ValidatorColor
import scanners.MyScanners
import java.io.Serializable

class BuilderColor(scanner: MyScanners) : IBuilder<Color>, Serializable {
    private val validatorColor = ValidatorColor()
    private val colorCollector = ColorCollector(scanner)

    override fun build(): Color? {
        return colorCollector.ask("Цвет", validatorColor)
    }
}