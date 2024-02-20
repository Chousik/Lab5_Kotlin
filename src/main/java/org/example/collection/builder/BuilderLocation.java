package org.example.collection.builder;

import org.example.collection.Location;
import org.example.collection.validators.ValidatorLocationName;
import org.example.collection.validators.ValidatorLocationX;
import org.example.collection.validators.ValidatorLocationYZ;
import org.example.exception.InvalidDataError;
import org.example.exception.ScriptExecutionError;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Класс строитель для создания объекта класса Location
 */
public class BuilderLocation implements IBuilder<Location> {
    private Boolean isScript;
    private Scanner scanner;
    private ValidatorLocationName validatorLocationName = new ValidatorLocationName();
    private ValidatorLocationX validatorLocationX = new ValidatorLocationX();
    private ValidatorLocationYZ validatorLocationYZ = new ValidatorLocationYZ();
    public BuilderLocation(){
        this.isScript = RunHandler.mode();
        this.scanner = RunHandler.getMainScaner();
    }
    /**
     * Метод для создания объекта класса Location
     * @return возвращает объект класса Location
     */
    @Override
    public Location build() throws ScriptExecutionError {
        return new Location(getX(), getY(), getZ(), getName());
    }
    /**
     * Метод для получения координаты X
     * @return возвращает координату X
     */
    private Double getX() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату X");
                }
                Double valueX = Double.parseDouble(scanner.nextLine().trim());
                validatorLocationX.valide(valueX);
                return valueX;
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptExecutionError("Координата X должна быть числом");
                }
                System.out.println("Координата X должна быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptExecutionError("Координата X не может быть null");
                }
                System.out.println("Координата X не может быть null");
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
    /**
     * Метод для получения координаты Y
     * @return возвращает координату Y
     */
    private Integer getY() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату Y");
                }
                Integer valueY = Integer.parseInt(scanner.nextLine().trim());
                validatorLocationYZ.valide(valueY);
                return valueY;
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptExecutionError("Координата Y должна быть числом");
                }
                System.out.println("Координата Y должна быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptExecutionError("Координата Y не может быть null");
                }
                System.out.println("Координата Y не может быть null");
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
    /**
     * Метод для получения координаты Z
     * @return возвращает координату Z
     */
    private int getZ() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату Z");
                }
                Integer valueZ = Integer.parseInt(scanner.nextLine().trim());
                validatorLocationYZ.valide(valueZ);
                return valueZ;
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptExecutionError("Координата Z должна быть числом");
                }
                System.out.println("Координата Z должна быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptExecutionError("Координата Z не может быть null");
                }
                System.out.println("Координата Z не может быть null");
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
    /**
     * Метод для получения имени локации
     * @return возвращает имя локации
     */
    private String getName() throws ScriptExecutionError {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите имя локации");
                }
                String nameLocation = scanner.nextLine().trim();
                if (nameLocation.equals("")){nameLocation = null;}
                validatorLocationName.valide(nameLocation);
                return nameLocation;
            } catch (InvalidDataError e){
                if (isScript){
                    throw new ScriptExecutionError("Полe имя локации не может быть пустым.");
                }
                System.out.println("Полe имя локации не может быть пустым.");
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
