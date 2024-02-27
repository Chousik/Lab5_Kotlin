package org.chousik.collection.builder;

import org.chousik.collection.Location;
import org.chousik.collection.builder.collectors.DoubleCollector;
import org.chousik.collection.builder.collectors.IntegerCollector;
import org.chousik.collection.builder.collectors.StringCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.validators.ValidatorLocationName;
import org.chousik.collection.validators.ValidatorLocationX;
import org.chousik.collection.validators.ValidatorLocationYZ;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса Location
 */
public class BuilderLocation implements IBuilder<Location> {
    private final IValidator<String> validatorLocationName = new ValidatorLocationName();
    private final IValidator<Double> validatorLocationX = new ValidatorLocationX();
    private final IValidator<Integer> validatorLocationYZ = new ValidatorLocationYZ();
    /**
     * Метод для создания объекта класса Location
     *
     * @return возвращает объект класса Location
     */
    @Override
    public Location build() throws ScriptExecutionError {
        return new Location(new DoubleCollector().ask("Координата X", validatorLocationX), new IntegerCollector().ask("Координата Y", validatorLocationYZ),
                new IntegerCollector().ask("Координата Z", validatorLocationYZ), new StringCollector().ask("Имя локации", validatorLocationName));
    }
}
