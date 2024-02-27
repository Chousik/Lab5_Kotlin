package org.chousik.collection.builder.collectors

import org.chousik.collection.validators.IValidator
import org.chousik.exception.ScriptExecutionError

interface ICollector<R, T> {
    @Throws(ScriptExecutionError::class)
    fun ask(name: String?, validator: IValidator<T>?): R
}