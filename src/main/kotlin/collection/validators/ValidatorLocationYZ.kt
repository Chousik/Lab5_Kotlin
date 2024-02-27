package org.chousik.collection.validators

/**
 * Валидатор координаты YZ
 */
class ValidatorLocationYZ : IValidator<Int?> {
    /**
     * Проверяет число на соответствие диапазону
     *
     * @param t число
     * @throws NullPointerException если число null
     */
    @Throws(NullPointerException::class)
    override fun valide(t: Int?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}