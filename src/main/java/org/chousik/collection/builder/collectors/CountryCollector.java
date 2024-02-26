package org.chousik.collection.builder.collectors;

import org.chousik.collection.Country;
import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public class CountryCollector extends EnumCollector<Country> {
    @Override
    public Country ask(String name, IValidator validator) throws ScriptExecutionError {
        return askEnum(name, validator, Country::valueOf, Country::getValue);
    }
}
