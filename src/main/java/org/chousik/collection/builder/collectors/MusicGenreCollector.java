package org.chousik.collection.builder.collectors;

import org.chousik.collection.MusicGenre;
import org.chousik.collection.validators.IValidator;
import org.chousik.exception.ScriptExecutionError;

public class MusicGenreCollector extends EnumCollector<MusicGenre> {
    @Override
    public MusicGenre ask(String name, IValidator<String> validator) throws ScriptExecutionError {
        return askEnum(name, validator, MusicGenre::valueOf, MusicGenre::getValue);
    }
}
