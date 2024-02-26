package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

import java.util.function.Function;

public class DoubleCollector extends NumberCollector<Double>{

    @Override
    public Double ask(String name, IValidator validator) throws ScriptExecutionError {
        return askNumer(name, validator, Double::parseDouble);
    }
}