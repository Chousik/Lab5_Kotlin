package org.chousik.collection.builder;

import org.chousik.exception.ScriptExecutionError;

/**
 * Интерфейс строителя
 *
 * @param <T> тип строимого объекта
 */
public interface IBuilder<T> {
    public T build() throws ScriptExecutionError;
}
