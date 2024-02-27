package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError

/**
 * Интерфейс валидатор
 *
 * @param <T> тип валидируемого объекта
</T> */
interface IValidator<T> : IValidator<String?>, IValidator<String?> {
    @Throws(InvalidDataError::class)
    fun valide(t: T)
}