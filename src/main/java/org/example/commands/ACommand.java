package org.example.commands;

import org.example.exception.ArgumentError;
import org.example.exception.ArgumentCountError;
import org.example.exception.ScriptExecutionError;

import java.io.FileNotFoundException;
/**
 * Абстрактный класс для команд
 */
public abstract class ACommand {
    private String name;
    private String info;
    private Integer countsArgument;
    public ACommand(String name, String info, Integer countsArgument) {
        this.name = name;
        this.info = info;
        this.countsArgument = countsArgument;
    }
    /**
     * Метод для проверки количества аргументов
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     */
    public void valideCountsArgument(String[] args) throws ArgumentCountError {
        if (args.length!=countsArgument) {throw new ArgumentCountError(countsArgument,args.length);}
    }
    /**
     * Метод для выполнения команды
     * @param args аргументы
     * @throws ArgumentCountError если количество аргументов не совпадает
     * @throws ScriptExecutionError если произошла ошибка во время выполнения скрипта
     * @throws ArgumentError если аргументы не корректны
     */
    public abstract void execute(String[] args) throws ArgumentCountError, ScriptExecutionError, ArgumentError;

    @Override
    public String toString() {
        return this.name + ": " + this.info;
    }
}

