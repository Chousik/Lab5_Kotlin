package org.example.collection.builder;

import org.example.exception.ScriptExecutionError;

public interface IBuilder<T> {
    public T build() throws ScriptExecutionError;
}
