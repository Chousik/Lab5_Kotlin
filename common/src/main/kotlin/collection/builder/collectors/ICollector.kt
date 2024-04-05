package collection.builder.collectors

import collection.validators.IValidator

interface ICollector<R, T> {
    fun ask(
        name: String,
        validator: IValidator<T?>,
    ): R?
}
