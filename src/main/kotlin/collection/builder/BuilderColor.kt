package org.chousik.collection.builder

import org.chousik.collection.Color
import org.chousik.collection.builder.collectors.ColorCollector
import org.chousik.collection.validators.ValidatorColor

class BuilderColor : IBuilder<Color?> {
    private val validatorColor: ValidatorColor = ValidatorColor()

    override fun build(): Color? {
        return ColorCollector().ask("Цвет", validatorColor)
    }
}