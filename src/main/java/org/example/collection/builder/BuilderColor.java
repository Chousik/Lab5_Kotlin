package org.example.collection.builder;

import org.example.collection.Color;
import org.example.collection.validators.ValidatorColor;
import org.example.exception.NotValidData;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderColor implements BuilderInterface<Color>{
    private Boolean isScript;
    private ValidatorColor ValidatorColor;
    private Scanner Scaner;
    public BuilderColor() {
        this.isScript = RunHandler.Mode();
        this.ValidatorColor = new ValidatorColor();
        this.Scaner = RunHandler.getMainScaner();
    }

    @Override
    public Color build() throws ScriptRunErorr {
        while (true){
            try {
                if (!isScript) {
                    System.out.println("Доступные цвета: " + Color.getValue());
                    System.out.println("Выберите один из цветов");
                }
                String strValue = Scaner.nextLine().trim().toUpperCase();
                ValidatorColor.valide(strValue);
                return Color.valueOf(strValue);
            }
            catch (NotValidData e){
                if (isScript){
                    throw new ScriptRunErorr("Введено неккоретное значение из списка.");
                }
                System.out.println("Введено неккоретное значение из списка.");
            }catch (NullPointerException e){
                if (isScript) {
                    throw new ScriptRunErorr("Значение не может быть null");
                }
                System.out.println("Значение не может быть null");
            }catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptRunErorr("Ошибка во время ввода данных коллекции из файла.");
                }
                System.out.println("Не нажимай Ctrl+D((((");
            } catch (Exception e){
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }
        }
    }
}
