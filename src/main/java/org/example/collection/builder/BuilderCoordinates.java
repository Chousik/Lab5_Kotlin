package org.example.collection.builder;

import org.example.collection.Coordinates;
import org.example.collection.validators.ValidatorCoordinatesX;
import org.example.collection.validators.ValidatorCoordinatesY;
import org.example.exception.NotValidData;
import org.example.exception.ScriptRunErorr;
import org.example.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BuilderCoordinates implements BuilderInterface<Coordinates>{
    private Scanner Scaner;
    private boolean isScript;
    private ValidatorCoordinatesX ValidatorCoordinatesX;
    private ValidatorCoordinatesY ValidatorCoordinatesY;
    public BuilderCoordinates(){
        this.Scaner = RunHandler.getMainScaner();
        this.isScript = RunHandler.Mode();
        this.ValidatorCoordinatesX = new ValidatorCoordinatesX();
        this.ValidatorCoordinatesY = new ValidatorCoordinatesY();
    }

    @Override
    public Coordinates build() throws ScriptRunErorr {
        return new Coordinates(getX(), getY());
    }
    private Float getX() throws ScriptRunErorr {
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату X, больше -645");
                }
                Float ValueX = Float.parseFloat(Scaner.nextLine().trim());
                ValidatorCoordinatesX.valide(ValueX);
                return ValueX;
            } catch (NotValidData e){
                if (isScript){
                    throw new ScriptRunErorr("Координата X меньше -645");
                }
                System.out.println("Координата X меньше -645");
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
            }
            catch (Exception e){
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }
    private float getY() throws ScriptRunErorr{
        while (true){
            try {
                if (!isScript){
                    System.out.println("Введите координату Y");
                }
                Float ValueY = Float.parseFloat(Scaner.nextLine().trim());
                ValidatorCoordinatesX.valide(ValueY);
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
            }catch (Exception e){
                System.out.println("Непридвиденная ошибка");
                System.exit(0);
            }

        }
    }
}
