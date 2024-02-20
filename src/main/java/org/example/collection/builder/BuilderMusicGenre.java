package org.example.collection.builder;

import org.example.collection.MusicGenre;
import org.example.collection.validators.ValidatorMusicGenre;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Класс строитель для создания объекта класса MusicGenre
 */
public class BuilderMusicGenre implements IBuilder<MusicGenre> {
    private Boolean isScript;
    private Scanner scanner;
    private ValidatorMusicGenre validatorMusicGenre;
    public BuilderMusicGenre() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
        this.validatorMusicGenre = new ValidatorMusicGenre();
    }
    /**
     * Метод для создания объекта класса MusicGenre
     * @return возвращает объект класса MusicGenre
     */
    @Override
    public MusicGenre build() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript) {
                    System.out.println("Доступные жанры: " + MusicGenre.getValue());
                    System.out.println("Выберите один из жанров");
                }
                String strValue = scanner.nextLine().trim().toUpperCase();
                if (strValue.equals("")){strValue = null;}
                validatorMusicGenre.valide(strValue);
                return MusicGenre.valueOf(strValue);
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
            }catch (Exception e){
                if (isScript){
                    throw new ScriptExecutionError("Непридвиденная ошибка");
                }
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }
        }
    }
}
