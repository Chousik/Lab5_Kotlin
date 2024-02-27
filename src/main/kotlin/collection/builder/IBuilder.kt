package org.chousik.collection.builder

import org.chousik.exception.ScriptExecutionError

/**
 * Интерфейс строителя
 *
 * @param <T> тип строимого объекта
</T> */
interface IBuilder<T> {
    @Throws(ScriptExecutionError::class)
    fun build(): T
}