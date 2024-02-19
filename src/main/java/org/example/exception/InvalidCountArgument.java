package org.example.exception;

public class InvalidCountArgument extends Exception{
    Integer CountCorrect;
    Integer Count;
    public InvalidCountArgument(Integer c1, Integer c2){
        super();
        CountCorrect = c1;
        Count = c2;
    }

    @Override
    public String toString() {
        return "Неверное кол-во аргумент: " + Count +", Должно быть: " + CountCorrect + ".";
    }
}
