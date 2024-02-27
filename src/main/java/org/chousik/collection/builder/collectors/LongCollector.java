package org.chousik.collection.builder.collectors;

import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public class LongCollector extends NumberCollector<Long>{

    @Override
    public Long ask(String name, IValidator<Long> validator) throws ScriptExecutionError {
        return askNumber(name, validator, Long::parseLong);
    }
}