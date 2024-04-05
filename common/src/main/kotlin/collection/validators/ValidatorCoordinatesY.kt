package collection.validators

class ValidatorCoordinatesY : IValidator<Float?> {
    override fun valid(t: Float?) {
        if (t == null) {
            throw NullPointerException()
        }
    }
}
