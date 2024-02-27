package org.chousik.collection.builder;

import org.chousik.collection.Color;
import org.chousik.collection.builder.collectors.ColorCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.validators.ValidatorColor;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса Color
 */
public class BuilderColor implements IBuilder<Color> {
    private final IValidator<String> validatorColor = new ValidatorColor();

    public BuilderColor() {
    }

    /**
     * Метод для создания объекта класса Color
     *
     * @return возвращает объект класса Color
     */
    @Override
    public Color build() throws ScriptExecutionError {
        return new ColorCollector().ask("Цвет", validatorColor);
    }
}
