package org.chousik.collection

import lombok.Getter
import lombok.Setter
import java.util.*

/**
 * Класс координаты
 */
@Getter
@Setter
class Location {
    private var x: Double? = null //Поле не может быть null
    private var y: Int? = null //Поле не может быть null
    private var z = 0
    private var name: String? = null //Поле может быть null

    constructor()

    constructor(x: Double?, y: Int?, z: Int, name: String?) {
        this.x = x
        this.y = y
        this.z = z
        this.name = name
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val location = o as Location
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