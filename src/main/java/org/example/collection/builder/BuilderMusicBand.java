package org.example.collection.builder;

import org.example.collection.MusicBand;
import org.example.collection.validators.ValidatorMusicBandAlbumsCount;
import org.example.collection.validators.ValidatorMusicBandName;
import org.example.collection.validators.ValidatorMusicBandNumberOfParticipants;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderMusicBand implements IBuilder<MusicBand> {
    private Boolean isScript;
    private Scanner scanner;
    private ValidatorMusicBandName validatorMusicBandName = new ValidatorMusicBandName();
    private ValidatorMusicBandAlbumsCount validatorMusicBandAlbumsCount = new ValidatorMusicBandAlbumsCount();
    private ValidatorMusicBandNumberOfParticipants validatorMusicBandNumberOfParticipants = new ValidatorMusicBandNumberOfParticipants();
    private BuilderCoordinates builderCoordinates = new BuilderCoordinates();
    private BuilderPerson builderPerson = new BuilderPerson();
    private BuilderMusicGenre builderMusicGenre = new BuilderMusicGenre();
    public BuilderMusicBand(){
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }

    @Override
    public MusicBand build() throws ScriptExecutionError {
        return new MusicBand(getName(), builderCoordinates.build(), getNumbersOfParticipants(), getAlbumsCount(), builderMusicGenre.build(), builderPerson.build());
    }
    public void reBuild(MusicBand musicBand) throws ScriptExecutionError{
        MusicBand newMusicBand = new MusicBand(getName(), builderCoordinates.build(), getNumbersOfParticipants(), getAlbumsCount(), builderMusicGenre.build(), builderPerson.build());
        musicBand.setName(newMusicBand.getName());
        musicBand.setCoordinates(newMusicBand.getCoordinates());
        musicBand.setNumberOfParticipants(newMusicBand.getNumberOfParticipants());
        musicBand.setAlbumsCount(newMusicBand.getAlbumsCount());
        musicBand.setGenre(newMusicBand.getGenre());
        musicBand.setFrontMan(newMusicBand.getFrontMan());
    }
    private String getName() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите имя группы");
                }
                String namePerson = scanner.nextLine().trim();
                validatorMusicBandName.valide(namePerson);
                return namePerson;
            } catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Имя группы не может быть пустым.");
                }
                System.out.println("Имя группы не может быть пустым.");
            }catch (NullPointerException e) {
                if (isScript){
                    throw new ScriptExecutionError("Имя группы не может быть null.");
                }
                System.out.println("Имя группы не может быть null.");
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
    private Long getAlbumsCount() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите количество альбомов, больше 0");
                }
                Long valueCounts = Long.parseLong(scanner.nextLine().trim());
                validatorMusicBandAlbumsCount.valide(valueCounts);
                return valueCounts;
            } catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Количество альбомов меньше 0");
                }
                System.out.println("Количество альбомов меньше 0");
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptExecutionError("Количество альбомов должно быть числом");
                }
                System.out.println("Количество альбомов должно быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptExecutionError("Количество альбомов не может быть null");
                }
                System.out.println("Количество альбомов не может быть null");
            }catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptExecutionError("Ошибка во время ввода данных коллекции из файла. Конец файла.");
                }
                System.out.println("Не нажимай Ctrl+D((((");
                System.exit(0);
            }
            catch (Exception e){
                if (isScript){
                    throw new ScriptExecutionError("Непридвиденная ошибка");
                }
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }
    private Long getNumbersOfParticipants() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите количество участников группы, больше 0");
                }
                Long numbersOfParticipants = Long.parseLong(scanner.nextLine().trim());
                validatorMusicBandNumberOfParticipants.valide(numbersOfParticipants);
                return numbersOfParticipants;
            } catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Количество участников меньше 0");
                }
                System.out.println("Количество участников  меньше 0");
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptExecutionError("Количество альбомов должно быть числом");
                }
                System.out.println("Количество участников  должно быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptExecutionError("Количество участников  не может быть null");
                }
                System.out.println("Количество участников  не может быть null");
            }catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptExecutionError("Ошибка во время ввода данных коллекции из файла. Конец файла.");
                }
                System.out.println("Не нажимай Ctrl+D((((");
                System.exit(0);
            }
            catch (Exception e){
                if (isScript){
                    throw new ScriptExecutionError("Непридвиденная ошибка");
                }
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }

}
