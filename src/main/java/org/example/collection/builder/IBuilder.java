package org.example.collection.builder;

import org.example.exception.ScriptExecutionError;
/**
 * Интерфейс строителя
 * @param <T> тип строимого объекта
 */
public interface IBuilder<T> {
    public T build() throws ScriptExecutionError;
}
