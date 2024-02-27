package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public interface ICollector<R, T> {
    R ask(String name, IValidator<T> validator) throws ScriptExecutionError;
}
