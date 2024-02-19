package org.example.collection.builder;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.example.collection.Country;
import org.example.collection.validators.ValidatorCountry;
import org.example.exception.NotValidData;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.RunHandler;

public class BuilderCountry implements BuilderInterface<Country>{
    private Boolean isScript;
    private ValidatorCountry ValidatorCountry;
    private Scanner Scaner;
    public BuilderCountry() {
        this.isScript = RunHandler.Mode();
        this.ValidatorCountry = new ValidatorCountry();
        this.Scaner = RunHandler.getMainScaner();
    }

    @Override
    public Country build() throws ScriptRunErorr {
        while (true){
            try {
                if (!isScript) {
                    System.out.println("Доступные страны: " + Country.getValue());
                    System.out.println("Выберите одну из стран");
                }
                String strValue = Scaner.nextLine().trim().toUpperCase();
                ValidatorCountry.valide(strValue);
                return Country.valueOf(strValue);
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
            }catch (Exception e){
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }
        }
    }
}
