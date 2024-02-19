package org.example.collection.builder;

import org.example.exception.ScriptRunErorr;

public interface BuilderInterface<T> {
    public T build() throws ScriptRunErorr;
}
