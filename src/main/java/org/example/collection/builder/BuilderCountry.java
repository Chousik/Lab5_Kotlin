package org.example.collection.builder;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.example.collection.Country;
import org.example.collection.validators.ValidatorCountry;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

/**
 * Класс строитель для создания объекта класса Country
 */
public class BuilderCountry implements IBuilder<Country> {
    private Boolean isScript;
    private ValidatorCountry validatorCountry = new ValidatorCountry();
    private Scanner scanner;

    public BuilderCountry() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }

    /**
     * Метод для создания объекта класса Country
     *
     * @return возвращает объект класса Country
     */
    @Override
    public Country build() throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Доступные страны: " + Country.getValue());
                    System.out.println("Выберите одну из стран");
                }
                String strValue = scanner.nextLine().trim().toUpperCase();
                if (strValue.equals("")) {
                    strValue = null;
                }
                validatorCountry.valide(strValue);
                return Country.valueOf(strValue);
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
