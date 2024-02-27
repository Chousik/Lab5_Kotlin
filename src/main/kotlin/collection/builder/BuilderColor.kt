package org.chousik.collection.builder

import org.chousik.collection.Color
import org.chousik.collection.builder.collectors.ColorCollector
import org.chousik.collection.validators.IValidator
import org.chousik.collection.validators.ValidatorColor
import org.chousik.exception.ScriptExecutionError

/**
 * Класс строитель для создания объекта класса Color
 */
class BuilderColor : IBuilder<Color?> {
    private val validatorColor: ValidatorColor = ValidatorColor()

    /**
     * Метод для создания объекта класса Color
     *
     * @return возвращает объект класса Color
     */
    @Throws(ScriptExecutionError::class)
    override fun build(): Color? {
        return ColorCollector().ask("Цвет", validatorColor)
    }
}