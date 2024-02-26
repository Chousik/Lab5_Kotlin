package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

import java.util.function.Function;

public class IntegerCollector extends NumberCollector<Integer>{

    @Override
    public Integer ask(String name, IValidator validator) throws ScriptExecutionError {
        return askNumer(name, validator, Integer::parseInt);
    }
}