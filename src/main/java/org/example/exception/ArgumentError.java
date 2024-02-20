package org.example.exception;
/**
 * Класс ошибки неверного аргумента
 */
public class ArgumentError extends Exception{
    public ArgumentError(String message){
        super(message);
    }
}
