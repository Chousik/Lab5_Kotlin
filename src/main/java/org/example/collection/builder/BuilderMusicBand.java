package org.example.collection.builder;

import org.example.collection.MusicBand;
import org.example.collection.validators.ValidatorMusicBandAlbumsCount;
import org.example.collection.validators.ValidatorMusicBandName;
import org.example.collection.validators.ValidatorMusicBandNumberOfParticipants;
import org.example.exception.NotValidData;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderMusicBand implements BuilderInterface<MusicBand>{
    private Boolean isScript;
    private Scanner Scaner;
    private ValidatorMusicBandName ValidatorMusicBandName = new ValidatorMusicBandName();
    private ValidatorMusicBandAlbumsCount ValidatorMusicBandAlbumsCount = new ValidatorMusicBandAlbumsCount();
    private ValidatorMusicBandNumberOfParticipants ValidatorMusicBandNumberOfParticipants= new ValidatorMusicBandNumberOfParticipants();
    private BuilderCoordinates BuilderCoordinates = new BuilderCoordinates();
    private BuilderPerson BuilderPerson = new BuilderPerson();
    private BuilderMusicGenre BuilderMusicGenre = new BuilderMusicGenre();
    public BuilderMusicBand(){
        this.isScript = RunHandler.Mode();
        this.Scaner = RunHandler.getMainScaner();
    }

    @Override
    public MusicBand build() throws ScriptRunErorr {
        return new MusicBand(getName(), BuilderCoordinates.build(), getNumbersOfParticipants(), getAlbumsCount(), BuilderMusicGenre.build(), BuilderPerson.build());
    }
    private String getName() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите имя группы");
                }
                String namePerson = Scaner.nextLine().trim();
                ValidatorMusicBandName.valide(namePerson);
                return namePerson;
            } catch (NotValidData e){
                if (isScript){
                    throw new ScriptRunErorr("Имя группы не может быть пустым.");
                }
                System.out.println("Имя группы не может быть пустым.");
            }catch (NullPointerException e) {
                if (isScript){
                    throw new ScriptRunErorr("Имя группы не может быть null.");
                }
                System.out.println("Имя группы не может быть null.");
            }
            catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptRunErorr("Ошибка во время ввода данных коллекции из файла.");
                }
                System.out.println("Не нажимай Ctrl+D((((");
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }
        }
    }
    private Long getAlbumsCount() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите количество альбомов, больше 0");
                }
                Long ValueCounts = Long.parseLong(Scaner.nextLine().trim());
                ValidatorMusicBandAlbumsCount.valide(ValueCounts);
                return ValueCounts;
            } catch (NotValidData e){
                if (isScript){
                    throw new ScriptRunErorr("Количество альбомов меньше 0");
                }
                System.out.println("Количество альбомов меньше 0");
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptRunErorr("Количество альбомов должно быть числом");
                }
                System.out.println("Количество альбомов должно быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptRunErorr("Количество альбомов не может быть null");
                }
                System.out.println("Количество альбомов не может быть null");
            }catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptRunErorr("Ошибка во время ввода данных коллекции из файла.");
                }
            }
            catch (Exception e){
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }
    private Long getNumbersOfParticipants() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите количество участников группы, больше 0");
                }
                Long NumbersOfParticipants = Long.parseLong(Scaner.nextLine().trim());
                ValidatorMusicBandNumberOfParticipants.valide(NumbersOfParticipants);
                return NumbersOfParticipants;
            } catch (NotValidData e){
                if (isScript){
                    throw new ScriptRunErorr("Количество участников меньше 0");
                }
                System.out.println("Количество участников  меньше 0");
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptRunErorr("Количество альбомов должно быть числом");
                }
                System.out.println("Количество участников  должно быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptRunErorr("Количество участников  не может быть null");
                }
                System.out.println("Количество участников  не может быть null");
            }catch (NoSuchElementException e){
                if (isScript) {
                    throw new ScriptRunErorr("Ошибка во время ввода данных коллекции из файла.");
                }
            }
            catch (Exception e){
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }

}
