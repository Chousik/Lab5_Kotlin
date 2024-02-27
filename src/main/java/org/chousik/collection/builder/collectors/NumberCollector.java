package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.*;

public abstract class NumberCollector<T extends Number> implements ICollector<T, T>{
    private final Boolean isScript;
    private final Scanner scanner;
    public NumberCollector() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }
    protected T askNumber(String name, IValidator<T> validator, Function<String, T> method) throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите " + name);
                    System.out.print(System.getProperty("user.name")+"> ");
                }
                String string = scanner.nextLine().trim();
                T t = method.apply(string);
                validator.valide(t);
                return t;
            } catch (NumberFormatException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Поле " + name + " должо быть числом");
                }
                System.out.println("Поле " + name + " должо быть числом");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Поле " + name + " не может быть null");
                }
                System.out.println("Поле " + name + " не может быть null");
            } catch (NoSuchElementException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Ошибка во время ввода данных коллекции из файла. Конец файла.");
                }
                System.out.println("Не нажимай Ctrl+D((((");
                System.exit(0);
            } catch (Exception e) {
                if (isScript) {
                    throw new ScriptExecutionError("Непридвиденная ошибка");
                }
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }
}
