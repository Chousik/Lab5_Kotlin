package org.chousik.collection.builder;

import org.chousik.collection.MusicBand;
import org.chousik.collection.builder.collectors.LongCollector;
import org.chousik.collection.builder.collectors.StringCollector;
import org.chousik.collection.validators.IValidator;
import org.chousik.collection.validators.ValidatorMusicBandAlbumsCount;
import org.chousik.collection.validators.ValidatorMusicBandName;
import org.chousik.collection.validators.ValidatorMusicBandNumberOfParticipants;
import org.chousik.exception.InvalidDataError;
import org.chousik.exception.ScriptExecutionError;
import org.chousik.handlers.RunHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс строитель для создания объекта класса MusicBand
 */
public class BuilderMusicBand implements IBuilder<MusicBand> {
    private final IValidator<String> validatorMusicBandName = new ValidatorMusicBandName();
    private final IValidator<Long> validatorMusicBandAlbumsCount = new ValidatorMusicBandAlbumsCount();
    private final IValidator<Long> validatorMusicBandNumberOfParticipants = new ValidatorMusicBandNumberOfParticipants();
    private final BuilderCoordinates builderCoordinates = new BuilderCoordinates();
    private final BuilderPerson builderPerson = new BuilderPerson();
    private final BuilderMusicGenre builderMusicGenre = new BuilderMusicGenre();

    /**
     * Метод для создания объекта класса MusicBand
     *
     * @return возвращает объект класса MusicBand
     */
    @Override
    public MusicBand build() throws ScriptExecutionError {
        return new MusicBand(new StringCollector().ask("Имя банды", validatorMusicBandName), builderCoordinates.build(), new LongCollector().ask("Кол-во участников группы", validatorMusicBandNumberOfParticipants),
                new LongCollector().ask("Кол-во альбомов группы", validatorMusicBandAlbumsCount), builderMusicGenre.build(), builderPerson.build());
    }

    /**
     * Метод для пересоздания объекта класса MusicBand
     *
     * @param musicBand - объект класса MusicBand
     */
    public void reBuild(MusicBand musicBand) throws ScriptExecutionError {
        MusicBand newMusicBand = new MusicBand(new StringCollector().ask("Имя банды", validatorMusicBandName), builderCoordinates.build(), new LongCollector().ask("Кол-во участников группы", validatorMusicBandNumberOfParticipants),
                new LongCollector().ask("Кол-во альбомов группы", validatorMusicBandAlbumsCount), builderMusicGenre.build(), builderPerson.build());
        musicBand.setName(newMusicBand.getName());
        musicBand.setCoordinates(newMusicBand.getCoordinates());
        musicBand.setNumberOfParticipants(newMusicBand.getNumberOfParticipants());
        musicBand.setAlbumsCount(newMusicBand.getAlbumsCount());
        musicBand.setGenre(newMusicBand.getGenre());
        musicBand.setFrontMan(newMusicBand.getFrontMan());
    }
}
