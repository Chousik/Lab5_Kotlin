package org.chousik.collection.builder

import org.chousik.exception.ScriptExecutionError


interface IBuilder<T> {
    @Throws(ScriptExecutionError::class)
    fun build(): T
}