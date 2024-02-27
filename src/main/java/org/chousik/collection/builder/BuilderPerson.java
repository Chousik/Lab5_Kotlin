package org.chousik.collection.builder;

import org.chousik.collection.Person;
import org.chousik.collection.builder.collectors.StringCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.validators.ValidatorPersonName;
import org.chousik.collection.validators.ValidatorPersonPasportID;
import org.chousik.exception.ScriptExecutionError;

/**
 * Класс строитель для создания объекта класса Person
 */
public class BuilderPerson implements IBuilder<Person> {
    private final IValidator<String> validatorPersonName = new ValidatorPersonName();
    private final IValidator<String> validatorPersonPasportID = new ValidatorPersonPasportID();
    private final BuilderColor BuilderColor  = new BuilderColor();
    private final BuilderLocation BuilderLocation = new BuilderLocation();
    private final BuilderCountry BuilderCountry = new BuilderCountry();

    /**
     * Метод для создания объекта класса Person
     *
     * @return возвращает объект класса Person
     */
    @Override
    public Person build() throws ScriptExecutionError {
        return new Person(new StringCollector().ask("Имя Человека", validatorPersonName), new StringCollector().ask("Паспорт айди", validatorPersonPasportID), BuilderColor.build(), BuilderCountry.build(), BuilderLocation.build());
    }
}
