package org.example.collection;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -645, Поле не может быть null
    private float y;
    public Coordinates(Float x, float y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(){}

    public Float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}