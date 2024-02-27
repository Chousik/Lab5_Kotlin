package org.chousik.collection.builder;

import org.chousik.collection.builder.collectors.FloatCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.Сoordinates;
import org.chousik.collection.validators.ValidatorCoordinatesX;
import org.chousik.collection.validators.ValidatorCoordinatesY;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса Coordinates
 */
public class BuilderCoordinates implements IBuilder<Сoordinates> {
    private final IValidator<Float> validatorCoordinatesX = new ValidatorCoordinatesX();
    private final IValidator<Float> validatorCoordinatesY = new ValidatorCoordinatesY();

    /**
     * Метод для создания объекта класса Coordinates
     *
     * @return возвращает объект класса Coordinates
     */
    @Override
    public Сoordinates build() throws ScriptExecutionError {
        return new Сoordinates(new FloatCollector().ask("Координата X", validatorCoordinatesX), new FloatCollector().ask("Координата Y", validatorCoordinatesY));
    }
}
