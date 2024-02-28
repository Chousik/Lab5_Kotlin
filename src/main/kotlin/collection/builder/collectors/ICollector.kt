package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator

interface ICollector<R, T> {

    fun ask(name: String, validator: IValidator<T>): R
}