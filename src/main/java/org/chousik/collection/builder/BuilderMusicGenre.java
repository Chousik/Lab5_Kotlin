package org.chousik.collection.builder;

import org.chousik.collection.MusicGenre;
import org.chousik.collection.builder.collectors.MusicGenreCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.validators.ValidatorMusicGenre;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса MusicGenre
 */
public class BuilderMusicGenre implements IBuilder<MusicGenre> {
    private final IValidator<String> validatorMusicGenre = new ValidatorMusicGenre();

    @Override
    public MusicGenre build() throws ScriptExecutionError {
        return new MusicGenreCollector().ask("Жанр музыки", validatorMusicGenre);
    }
}
