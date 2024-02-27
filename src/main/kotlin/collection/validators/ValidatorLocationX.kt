package org.chousik.collection.validators

/**
 * Валидатор координаты X
 */
class ValidatorLocationX : IValidator<Double?> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param t число
     * @throws NullPointerException если число null
     */
    @Throws(NullPointerException::class)
    override fun valide(t: Double?) {
        if ((t == null) or t!!.isNaN()) {
            throw NullPointerException()
        }
    }
}