package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

import java.util.function.Function;

public class LongCollector extends NumberCollector<Long> implements ICollector<Long>{

    @Override
    public Long ask(String name, IValidator validator) throws ScriptExecutionError {
        return askNumer(name, validator, Long::parseLong);
    }
}