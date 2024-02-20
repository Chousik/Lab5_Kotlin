package org.example.collection;

import java.util.Objects;

/**
 * Класс координаты
 */
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

    public Double getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZ(int z) {
        this.z = z;
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
