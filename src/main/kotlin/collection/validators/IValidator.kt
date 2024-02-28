package org.chousik.collection.validators


interface IValidator<T> {
    fun valide(t: T)
}