package org.example.collection;

import java.util.Objects;
/**
 * Класс координат
 */
public class Сoordinates {
    private Float x; //Значение поля должно быть больше -645, Поле не может быть null
    private float y;
    public Сoordinates(Float x, float y){
        this.x = x;
        this.y = y;
    }
    public Сoordinates(){}

    public Float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сoordinates that = (Сoordinates) o;
        return Float.compare(y, that.y) == 0 && Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}