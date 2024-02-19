package org.example.collection;

public class Location {
    private Double x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private int z;
    private String name; //Поле может быть null
    public Location(){};
    public Location(Double x, Integer y, int z, String name){
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
