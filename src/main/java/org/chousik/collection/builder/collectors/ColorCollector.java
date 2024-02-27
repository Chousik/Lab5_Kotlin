package org.chousik.collection.builder.collectors;

import org.chousik.collection.Color;
import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public class ColorCollector extends EnumCollector<Color> {
    @Override
    public Color ask(String name, IValidator<String> validator) throws ScriptExecutionError {
        return askEnum(name,validator, Color::valueOf, Color::getValue);
    }
}
