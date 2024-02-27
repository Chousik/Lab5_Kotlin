package org.chousik.collection

import lombok.Getter
import lombok.Setter
import java.util.*

/**
 * Класс координат
 */
@Getter
@Setter
class Сoordinates {
    private var x: Float? = null //Значение поля должно быть больше -645, Поле не может быть null
    private var y = 0f

    constructor(x: Float?, y: Float) {
        this.x = x
        this.y = y
    }

    constructor()

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as Сoordinates
        return java.lang.Float.compare(y, that.y) == 0 && Objects.equals(x, that.x)
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y)
    }

    override fun toString(): String {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}'
    }
}