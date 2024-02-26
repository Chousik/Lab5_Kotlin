package org.chousik.collection.validators;

/**
 * Валидатор координаты YZ
 */
public class ValidatorLocationYZ implements IValidator<Integer> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param integer число
     * @throws NullPointerException если число null
     */
    @Override
    public void valide(Integer integer) throws NullPointerException {
        if (integer == null) {
            throw new NullPointerException();
        }
    }
}
