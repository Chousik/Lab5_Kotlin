package org.chousik.collection.builder;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.chousik.collection.Country;
import org.chousik.collection.builder.collectors.CountryCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.validators.ValidatorCountry;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import javax.crypto.CipherOutputStream;

/**
 * Класс строитель для создания объекта класса Country
 */
public class BuilderCountry implements IBuilder<Country> {
    private final IValidator<String> validatorCountry = new ValidatorCountry();

    /**
     * Метод для создания объекта класса Country
     *
     * @return возвращает объект класса Country
     */
    @Override
    public Country build() throws ScriptExecutionError {
    return new CountryCollector().ask("Страна", validatorCountry);
    }
}
