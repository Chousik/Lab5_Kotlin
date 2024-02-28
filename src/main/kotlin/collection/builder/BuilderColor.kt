package org.chousik.collection.builder

import org.chousik.collection.Color
import org.chousik.collection.builder.collectors.ColorCollector
import org.chousik.collection.validators.IValidator
import org.chousik.collection.validators.ValidatorColor
import org.chousik.exception.ScriptExecutionError

class BuilderColor : IBuilder<Color?> {
    private val validatorColor: ValidatorColor = ValidatorColor()

    @Throws(ScriptExecutionError::class)
    override fun build(): Color? {
        return ColorCollector().ask("Цвет", validatorColor)
    }
}