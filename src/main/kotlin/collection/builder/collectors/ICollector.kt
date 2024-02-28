package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError

interface ICollector<R, T> {

    fun ask(name: String, validator: IValidator<T>): R
}