package org.chousik.collection.validators;

import org.chousik.collection.MusicGenre;
import org.chousik.exception.InvalidDataError;

/**
 * Валидатор жанра музыки
 */
public class ValidatorMusicGenre implements Validator<String> {
    /**
     * Проверяет строку на соответствие жанру музыки
     *
     * @param s строка
     * @throws InvalidDataError     если строка не соответствует жанру музыки
     * @throws NullPointerException если строка null
     */
    @Override
    public void valide(String s) throws InvalidDataError, NullPointerException {
        try {
            MusicGenre.valueOf(s);
        } catch (IllegalArgumentException ex) {
            throw new InvalidDataError();
        }
    }
}
