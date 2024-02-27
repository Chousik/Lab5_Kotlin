package org.chousik.collection;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Класс координаты
 */
@Getter
@Setter
public class Location {
    private Double x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private int z;
    private String name; //Поле может быть null

    public Location() {
    }

    public Location(Double x, Integer y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return z == location.z && Objects.equals(x, location.x) && Objects.equals(y, location.y) && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }
}
