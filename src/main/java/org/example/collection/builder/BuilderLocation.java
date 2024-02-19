package org.example.collection.builder;

import org.example.collection.Location;
import org.example.collection.validators.ValidatorLocationName;
import org.example.collection.validators.ValidatorLocationX;
import org.example.collection.validators.ValidatorLocationYZ;
import org.example.exception.NotValidData;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderLocation implements BuilderInterface<Location>{
    private Boolean isScript;
    private Scanner Scaner;
    private ValidatorLocationName ValidatorLocationName;
    private ValidatorLocationX ValidatorLocationX;
    private ValidatorLocationYZ ValidatorLocationYZ;
    public BuilderLocation(){
        this.isScript = RunHandler.Mode();
        this.Scaner = RunHandler.getMainScaner();
        this.ValidatorLocationName = new ValidatorLocationName();
        this.ValidatorLocationX = new ValidatorLocationX();
        this.ValidatorLocationYZ = new ValidatorLocationYZ();
    }

    @Override
    public Location build() throws ScriptRunErorr {
        return new Location(getX(), getY(), getZ(), getName());
    }
    private Double getX() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату X");
                }
                Double ValueX = Double.parseDouble(Scaner.nextLine().trim());
                ValidatorLocationX.valide(ValueX);
                return ValueX;
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptRunErorr("Координата X должна быть числом");
                }
                System.out.println("Координата X должна быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptRunErorr("Координата X не может быть null");
                }
                System.out.println("Координата X не может быть null");
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
    private Integer getY() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату Y");
                }
                Integer ValueY = Integer.parseInt(Scaner.nextLine().trim());
                ValidatorLocationYZ.valide(ValueY);
                return ValueY;
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptRunErorr("Координата Y должна быть числом");
                }
                System.out.println("Координата Y должна быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptRunErorr("Координата Y не может быть null");
                }
                System.out.println("Координата Y не может быть null");
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
    private int getZ() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату Z");
                }
                Integer ValueZ = Integer.parseInt(Scaner.nextLine().trim());
                ValidatorLocationYZ.valide(ValueZ);
                return ValueZ;
            } catch (NumberFormatException e){
                if (isScript){
                    throw new ScriptRunErorr("Координата Z должна быть числом");
                }
                System.out.println("Координата Z должна быть числом");
            }catch (NullPointerException e){
                if (isScript){
                    throw new ScriptRunErorr("Координата Z не может быть null");
                }
                System.out.println("Координата Z не может быть null");
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
    private String getName() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите имя локации");
                }
                String nameLocation = Scaner.nextLine().trim();
                if (nameLocation.equals("")){nameLocation = null;}
                ValidatorLocationName.valide(nameLocation);
                return nameLocation;
            } catch (NotValidData e){
                if (isScript){
                    throw new ScriptRunErorr("Полe имя локации не может быть пустым.");
                }
                System.out.println("Полe имя локации не может быть пустым.");
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
