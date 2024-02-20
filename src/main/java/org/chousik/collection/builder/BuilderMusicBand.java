package org.chousik.collection.builder;

import org.chousik.collection.MusicBand;
import org.chousik.collection.validators.ValidatorMusicBandAlbumsCount;
import org.chousik.collection.validators.ValidatorMusicBandName;
import org.chousik.collection.validators.ValidatorMusicBandNumberOfParticipants;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса MusicBand
 */
public class BuilderMusicBand implements IBuilder<MusicBand> {
    private Boolean isScript;
    private Scanner scanner;
    private ValidatorMusicBandName validatorMusicBandName = new ValidatorMusicBandName();
    private ValidatorMusicBandAlbumsCount validatorMusicBandAlbumsCount = new ValidatorMusicBandAlbumsCount();
    private ValidatorMusicBandNumberOfParticipants validatorMusicBandNumberOfParticipants = new ValidatorMusicBandNumberOfParticipants();
    private BuilderCoordinates builderCoordinates = new BuilderCoordinates();
    private BuilderPerson builderPerson = new BuilderPerson();
    private BuilderMusicGenre builderMusicGenre = new BuilderMusicGenre();

    public BuilderMusicBand() {
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }

    /**
     * Метод для создания объекта класса MusicBand
     *
     * @return возвращает объект класса MusicBand
     */
    @Override
    public MusicBand build() throws ScriptExecutionError {
        return new MusicBand(getName(), builderCoordinates.build(), getNumbersOfParticipants(), getAlbumsCount(), builderMusicGenre.build(), builderPerson.build());
    }

    /**
     * Метод для пересоздания объекта класса MusicBand
     *
     * @param musicBand - объект класса MusicBand
     */
    public void reBuild(MusicBand musicBand) throws ScriptExecutionError {
        MusicBand newMusicBand = new MusicBand(getName(), builderCoordinates.build(), getNumbersOfParticipants(), getAlbumsCount(), builderMusicGenre.build(), builderPerson.build());
        musicBand.setName(newMusicBand.getName());
        musicBand.setCoordinates(newMusicBand.getCoordinates());
        musicBand.setNumberOfParticipants(newMusicBand.getNumberOfParticipants());
        musicBand.setAlbumsCount(newMusicBand.getAlbumsCount());
        musicBand.setGenre(newMusicBand.getGenre());
        musicBand.setFrontMan(newMusicBand.getFrontMan());
    }

    /**
     * Метод для получения имени группы
     *
     * @return возвращает имя группы
     */
    private String getName() throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите имя группы");
                }
                String namePerson = scanner.nextLine().trim();
                validatorMusicBandName.valide(namePerson);
                return namePerson;
            } catch (InvalidDataError e) {
                if (isScript) {
                    throw new ScriptExecutionError("Имя группы не может быть пустым.");
                }
                System.out.println("Имя группы не может быть пустым.");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Имя группы не может быть null.");
                }
                System.out.println("Имя группы не может быть null.");
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
     * Метод для получения количества альбомов
     *
     * @return возвращает количество альбомов
     */
    private Long getAlbumsCount() throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите количество альбомов, больше 0");
                }
                Long valueCounts = Long.parseLong(scanner.nextLine().trim());
                validatorMusicBandAlbumsCount.valide(valueCounts);
                return valueCounts;
            } catch (InvalidDataError e) {
                if (isScript) {
                    throw new ScriptExecutionError("Количество альбомов меньше 0");
                }
                System.out.println("Количество альбомов меньше 0");
            } catch (NumberFormatException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Количество альбомов должно быть числом");
                }
                System.out.println("Количество альбомов должно быть числом");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Количество альбомов не может быть null");
                }
                System.out.println("Количество альбомов не может быть null");
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
     * Метод для получения количества участников
     *
     * @return возвращает количество участников
     */
    private Long getNumbersOfParticipants() throws ScriptExecutionError {
        while (true) {
            try {
                if (!isScript) {
                    System.out.println("Введите количество участников группы, больше 0");
                }
                Long numbersOfParticipants = Long.parseLong(scanner.nextLine().trim());
                validatorMusicBandNumberOfParticipants.valide(numbersOfParticipants);
                return numbersOfParticipants;
            } catch (InvalidDataError e) {
                if (isScript) {
                    throw new ScriptExecutionError("Количество участников меньше 0");
                }
                System.out.println("Количество участников  меньше 0");
            } catch (NumberFormatException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Количество альбомов должно быть числом");
                }
                System.out.println("Количество участников  должно быть числом");
            } catch (NullPointerException e) {
                if (isScript) {
                    throw new ScriptExecutionError("Количество участников  не может быть null");
                }
                System.out.println("Количество участников  не может быть null");
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
