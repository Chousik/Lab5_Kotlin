package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public class DoubleCollector extends NumberCollector<Double>{

    @Override
    public Double ask(String name, IValidator<Double> validator) throws ScriptExecutionError {
        return askNumber(name, validator, Double::parseDouble);
    }
}