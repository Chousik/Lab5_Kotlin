package org.chousik.collection.validators

/**
 * Валидатор координаты Y
 */
class ValidatorCoordinatesY : IValidator<Float?> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param t число
     * @throws NullPointerException если число null
     */
    @Throws(NullPointerException::class)
    override fun valide(t: Float?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}