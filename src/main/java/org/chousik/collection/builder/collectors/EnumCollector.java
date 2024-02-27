package org.chousik.collection.builder.collectors;

import org.chousik.collection.Color;
import org.chousik.collection.validators.IValidator;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.Enum;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class EnumCollector<T extends Enum> implements ICollector<T, String> {
    private final Boolean isScript;
    private final Scanner scanner;

    public EnumCollector() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }

    protected T askEnum(String name, IValidator<String> validator, Function<String, T> method1, Supplier<String> method2) throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Доступные варианты поля " + name + ": " + method2.get());
                    System.out.println("Выберите один из вариантов");
                    System.out.print(System.getProperty("user.name")+"> ");
                }
                String strValue = scanner.nextLine().trim().toUpperCase();
                if (strValue.isEmpty()) {
                    strValue = null;
                }
                validator.valide(strValue);
                return method1.apply(strValue);
            } catch (InvalidDataError e) {
                if (isScript) {
                    throw new ScriptExecutionError("Введено неккоретное значение из списка.");
                }
                System.out.println("Введено неккоретное значение из списка.");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Значение не может быть null");
                }
                System.out.println("Значение не может быть null");
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
