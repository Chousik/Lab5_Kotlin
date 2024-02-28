package org.chousik.collection

import java.util.*

class Coordinates(private var x: Float, private var y: Float) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Coordinates
        return y.compareTo(that.y) == 0 && Objects.equals(x, that.x)
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