package org.chousik.collection.validators

import org.chousik.exception.InvalidDataError


interface IValidator<T> {
    fun valide(t: T)
}