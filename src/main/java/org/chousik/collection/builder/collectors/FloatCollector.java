package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

import java.util.function.Function;

public class FloatCollector extends NumberCollector<Float>{

    @Override
    public Float ask(String name, IValidator<Float> validator) throws ScriptExecutionError {
        return askNumber(name, validator, Float::parseFloat);
    }
}
