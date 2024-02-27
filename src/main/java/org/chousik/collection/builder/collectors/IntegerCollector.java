package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public class IntegerCollector extends NumberCollector<Integer>{

    @Override
    public Integer ask(String name, IValidator<Integer> validator) throws ScriptExecutionError {
        return askNumber(name, validator, Integer::parseInt);
    }
}