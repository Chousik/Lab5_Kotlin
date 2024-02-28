package org.chousik.collection.builder

import org.chousik.collection.MusicBand
import org.chousik.collection.builder.collectors.LongCollector
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.ValidatorMusicBandAlbumsCount
import org.chousik.collection.validators.ValidatorMusicBandName
import org.chousik.collection.validators.ValidatorMusicBandNumberOfParticipants
import org.chousik.exception.ScriptExecutionError


class BuilderMusicBand : IBuilder<MusicBand?> {
    private val validatorMusicBandName: ValidatorMusicBandName = ValidatorMusicBandName()
    private val validatorMusicBandAlbumsCount: ValidatorMusicBandAlbumsCount = ValidatorMusicBandAlbumsCount()
    private val validatorMusicBandNumberOfParticipants: ValidatorMusicBandNumberOfParticipants = ValidatorMusicBandNumberOfParticipants()
    private val builderCoordinates: BuilderCoordinates = BuilderCoordinates()
    private val builderPerson = BuilderPerson()
    private val builderMusicGenre = BuilderMusicGenre()


    override fun build(): MusicBand {
        return MusicBand(
            StringCollector().ask("Имя банды", validatorMusicBandName),
            builderCoordinates.build(),
            LongCollector().ask("Кол-во участников группы", validatorMusicBandNumberOfParticipants),
            LongCollector().ask("Кол-во альбомов группы", validatorMusicBandAlbumsCount),
            builderMusicGenre.build(),
            builderPerson.build()
        )
    }


    fun reBuild(musicBand: MusicBand) {
        val newMusicBand = MusicBand(
            StringCollector().ask("Имя банды", validatorMusicBandName),
            builderCoordinates.build(),
            LongCollector().ask("Кол-во участников группы", validatorMusicBandNumberOfParticipants),
            LongCollector().ask("Кол-во альбомов группы", validatorMusicBandAlbumsCount),
            builderMusicGenre.build(),
            builderPerson.build()
        )
//        musicBand.g(newMusicBand.getName()!!)
//        musicBand.setCoordinates(newMusicBand.getCoordinates())
//        musicBand.setNumberOfParticipants(newMusicBand.getNumberOfParticipants())
//        musicBand.setAlbumsCount(newMusicBand.getAlbumsCount())
//        musicBand.setGenre(newMusicBand.getGenre())
//        musicBand.setFrontMan(newMusicBand.getFrontMan())
    }
}