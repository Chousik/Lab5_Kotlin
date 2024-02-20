package org.example.exception;
/**
 * Класс ошибки неверного кол-ва аргументов
 */
public class ArgumentCountError extends Exception{
    Integer сountCorrect;
    Integer сount;
    public ArgumentCountError(Integer сountCorrect, Integer сount){
        super();
        this.сount = сount;
        this.сountCorrect = сountCorrect;
    }

    @Override
    public String toString() {
        return "Неверное кол-во аргумент: " + сount +", Должно быть: " + сountCorrect + ".";
    }
}
