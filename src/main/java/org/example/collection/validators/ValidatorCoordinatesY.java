package org.example.collection.validators;

/**
 * Валидатор координаты Y
 */
public class ValidatorCoordinatesY implements Validator<Float> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param aFloat число
     * @throws NullPointerException если число null
     */
    @Override
    public void valide(Float aFloat) throws NullPointerException {
        if (aFloat == null) {
            throw new NullPointerException();
        }
    }
}
