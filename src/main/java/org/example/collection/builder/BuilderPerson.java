package org.example.collection.builder;

import org.example.collection.Person;
import org.example.collection.validators.ValidatorPersonName;
import org.example.collection.validators.ValidatorPersonPasportID;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderPerson implements IBuilder<Person> {
    private Boolean isScript;
    private Scanner Scaner;
    private ValidatorPersonName ValidatorPersonName;
    private ValidatorPersonPasportID ValidatorPersonPasportID;
    private BuilderColor BuilderColor;
    private BuilderLocation BuilderLocation;
    private BuilderCountry BuilderCountry;
    public BuilderPerson(){
        this.isScript = RunHandler.mode();
        this.Scaner = RunHandler.getMainScaner();
        this.ValidatorPersonName = new ValidatorPersonName();
        this.ValidatorPersonPasportID = new ValidatorPersonPasportID();
        this.BuilderCountry = new BuilderCountry();
        this.BuilderColor = new BuilderColor();
        this.BuilderLocation = new BuilderLocation();
    }

    @Override
    public Person build() throws ScriptExecutionError {
        return new Person(getName(), getPassportID(), BuilderColor.build(), BuilderCountry.build(),BuilderLocation.build());
    }


    private String getName() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите имя человека");
                }
                String namePerson = Scaner.nextLine().trim();
                ValidatorPersonName.valide(namePerson);
                return namePerson;
            } catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Имя человека не может быть пустым.");
                }
                System.out.println("Имя человека не может быть пустым.");
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

    private String getPassportID() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите паспорт айди");
                }
                String passportID = Scaner.nextLine().trim();
                ValidatorPersonPasportID.valide(passportID);
                return passportID;
            } catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Поле пасспорт айди должно быть не меньше 6 символов");
                }
                System.out.println("Поле пасспорт айди должно быть не меньше 6 символов");
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
