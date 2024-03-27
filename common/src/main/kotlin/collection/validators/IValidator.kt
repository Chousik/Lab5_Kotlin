package collection.validators


interface IValidator<T> {
    fun valid(t: T)
}