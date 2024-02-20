package org.example.collection.builder;

import org.example.collection.Сoordinates;
import org.example.collection.validators.ValidatorCoordinatesX;
import org.example.collection.validators.ValidatorCoordinatesY;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса Coordinates
 */
public class BuilderCoordinates implements IBuilder<Сoordinates> {
    private Scanner scanner;
    private boolean isScript;
    private ValidatorCoordinatesX validatorCoordinatesX = new ValidatorCoordinatesX();
    private ValidatorCoordinatesY validatorCoordinatesY = new ValidatorCoordinatesY();

    public BuilderCoordinates() {
        this.scanner = RunHandler.getMainScaner();
        this.isScript = RunHandler.mode();
    }

    /**
     * Метод для создания объекта класса Coordinates
     *
     * @return возвращает объект класса Coordinates
     */
    @Override
    public Сoordinates build() throws ScriptExecutionError {
        return new Сoordinates(getX(), getY());
    }

    /**
     * Метод для получения координаты X
     *
     * @return возвращает координату X
     */
    private Float getX() throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите координату X, больше -645");
                }
                Float valueX = Float.parseFloat(scanner.nextLine().trim());
                validatorCoordinatesX.valide(valueX);
                return valueX;
            } catch (InvalidDataError e) {
                if (isScript) {
                    throw new ScriptExecutionError("Координата X меньше -645");
                }
                System.out.println("Координата X меньше -645");
            } catch (NumberFormatException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Координата X должна быть числом");
                }
                System.out.println("Координата X должна быть числом");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Координата X не может быть null");
                }
                System.out.println("Координата X не может быть null");
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

    /**
     * Метод для получения координаты Y
     *
     * @return возвращает координату Y
     */
    private float getY() throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите координату Y");
                }
                Float valueY = Float.parseFloat(scanner.nextLine().trim());
                validatorCoordinatesX.valide(valueY);
                return valueY;
            } catch (NumberFormatException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Координата Y должна быть числом");
                }
                System.out.println("Координата Y должна быть числом");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Координата Y не может быть null");
                }
                System.out.println("Координата Y не может быть null");
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
