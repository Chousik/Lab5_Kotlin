package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public interface ICollector<T> {
    T ask(String name, IValidator validator) throws ScriptExecutionError;
}
