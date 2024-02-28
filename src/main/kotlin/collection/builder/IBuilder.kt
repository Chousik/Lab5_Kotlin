package org.chousik.collection.builder

import org.chousik.exception.ScriptExecutionError


interface IBuilder<T> {
    fun build(): T
}