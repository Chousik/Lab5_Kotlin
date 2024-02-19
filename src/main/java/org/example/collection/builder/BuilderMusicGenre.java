package org.example.collection.builder;

import org.example.collection.MusicGenre;
import org.example.collection.validators.ValidatorMusicGenre;
import org.example.exception.NotValidData;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderMusicGenre implements BuilderInterface<MusicGenre>{
    private Boolean isScript;
    private Scanner scanner;
    private ValidatorMusicGenre validatorMusicGenre;
    public BuilderMusicGenre() {
        this.isScript = RunHandler.Mode();
        this.scanner = RunHandler.getMainScaner();
        this.validatorMusicGenre = new ValidatorMusicGenre();
    }

    @Override
    public MusicGenre build() throws ScriptRunErorr {
        while (true){
            try {
                if (!isScript) {
                    System.out.println("Доступные жанры: " + MusicGenre.getValue());
                    System.out.println("Выберите один из жанров");
                }
                String strValue = scanner.nextLine().trim().toUpperCase();
                validatorMusicGenre.valide(strValue);
                return MusicGenre.valueOf(strValue);
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
