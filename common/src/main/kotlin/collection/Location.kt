package collection

import java.io.Serializable
import java.util.Objects

class Location(private val x: Double, private val y: Int, private val z: Int, private val name: String) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val location = other as Location
        return z == location.z && Objects.equals(x, location.x) && y == location.y && name == location.name
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y, z, name)
    }

    override fun toString(): String {
        return "Location{" +
            "x=" + x +
            ", y=" + y +
            ", z=" + z +
            ", name='" + name + '\'' +
            '}'
    }
}
