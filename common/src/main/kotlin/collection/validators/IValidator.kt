package org.chousik.collection.validators


interface IValidator<T> {
    fun valid(t: T)
}