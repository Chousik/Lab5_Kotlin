package org.chousik.collection.validators;

import org.chousik.exception.InvalidDataError;

/**
 * Валидатор координаты X
 */
public class ValidatorCoordinatesX implements IValidator<Float> {

    /**
     * Проверяет число на соответствие диапазону
     *
     * @param aFloat число
     * @throws InvalidDataError     если число не соответствует диапазону
     * @throws NullPointerException если число null
     */
    @Override
    public void valide(Float aFloat) throws InvalidDataError, NullPointerException {
        if (aFloat == null) {
            throw new NullPointerException();
        }
        if (aFloat <= -645) {
            throw new InvalidDataError();
        }
    }
}
