package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


interface IValidator<T> {
    @Throws(InvalidDataError::class)
    fun valide(t: T)
}