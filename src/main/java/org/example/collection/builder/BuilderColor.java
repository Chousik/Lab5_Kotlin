package org.example.collection.builder;

import org.example.collection.Color;
import org.example.collection.validators.ValidatorColor;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderColor implements IBuilder<Color> {
    private Boolean isScript;
    private ValidatorColor validatorColor = new ValidatorColor();
    private Scanner scanner;
    public BuilderColor() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }

    @Override
    public Color build() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript) {
                    System.out.println("Доступные цвета: " + Color.getValue());
                    System.out.println("Выберите один из цветов");
                }
                String strValue = scanner.nextLine().trim().toUpperCase();
                validatorColor.valide(strValue);
                return Color.valueOf(strValue);
            }
            catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Введено неккоретное значение из списка.");
                }
                System.out.println("Введено неккоретное значение из списка.");
            }catch (NullPointerException e){
                if (isScript) {
                    throw new ScriptExecutionError("Значение не может быть null");
                }
                System.out.println("Значение не может быть null");
            }catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptExecutionError("Ошибка во время ввода данных коллекции из файла. Конец файла.");
                }
                System.out.println("Не нажимай Ctrl+D((((");
                System.exit(0);
            } catch (Exception e){
                if (isScript){
                    throw new ScriptExecutionError("Непридвиденная ошибка");
                }
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }
        }
    }
}
