package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringCollector implements ICollector<String>{
    private Boolean isScript;
    private Scanner scanner;
    public void NumberCollecto() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }

    @Override
    public String get(String name, IValidator validator) throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите " + name);
                }
                String namePerson = scanner.nextLine().trim();
                validator.valide(namePerson);
                return namePerson;
            } catch (InvalidDataError e) {
                if (isScript) {
                    throw new ScriptExecutionError("Поле " + name + " не может быть пустым.");
                }
                System.out.println("Поле " + name + " не может быть пустым.");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Поле " + name + " не может быть null.");
                }
                System.out.println("Поле " + name + " не может быть null.");
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
