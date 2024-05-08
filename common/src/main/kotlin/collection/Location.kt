package collection

import org.springframework.data.annotation.Id
import java.io.Serializable
import java.util.Objects

class Location(val x: Double, val y: Int, val z: Int, val name: String) : Serializable {
    @Id
    val id: Long = 0

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
