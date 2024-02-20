package org.example.collection.validators;

/**
 * Валидатор координаты X
 */
public class ValidatorLocationX implements Validator<Double> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param aDouble число
     * @throws NullPointerException если число null
     */
    @Override
    public void valide(Double aDouble) throws NullPointerException {
        if (aDouble == null | aDouble.isNaN()) {
            throw new NullPointerException();
        }
    }
}
