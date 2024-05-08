package collection

import java.io.Serializable
import java.util.Objects

class Coordinates(val x: Float, val y: Float) : Serializable {
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
