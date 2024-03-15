package org.chousik.collection.builder

import org.chousik.collection.MusicBand
import org.chousik.collection.builder.collectors.LongCollector
import org.chousik.collection.builder.collectors.StringCollector
import org.chousik.collection.validators.ValidatorMusicBandAlbumsCount
import org.chousik.collection.validators.ValidatorMusicBandName
import org.chousik.collection.validators.ValidatorMusicBandNumberOfParticipants


class BuilderMusicBand : IBuilder<MusicBand> {
    private val validatorMusicBandName: ValidatorMusicBandName = ValidatorMusicBandName()
    private val validatorMusicBandAlbumsCount: ValidatorMusicBandAlbumsCount = ValidatorMusicBandAlbumsCount()
    private val validatorMusicBandNumberOfParticipants: ValidatorMusicBandNumberOfParticipants = ValidatorMusicBandNumberOfParticipants()
    private val builderCoordinates: BuilderCoordinates = BuilderCoordinates()
    private val builderPerson = BuilderPerson()
    private val builderMusicGenre = BuilderMusicGenre()
    private val stringCollector = StringCollector()
    private val longCollector = LongCollector()



    override fun build(): MusicBand {
        return MusicBand(
            stringCollector.ask("Имя банды", validatorMusicBandName),
            builderCoordinates.build(),
            longCollector.ask("Кол-во участников группы", validatorMusicBandNumberOfParticipants),
            longCollector.ask("Кол-во альбомов группы", validatorMusicBandAlbumsCount),
            builderMusicGenre.build(),
            builderPerson.build()
        )
    }


    fun reBuild(musicBand: MusicBand) {
        val newMusicBand = MusicBand(
            stringCollector.ask("Имя банды", validatorMusicBandName),
            builderCoordinates.build(),
            longCollector.ask("Кол-во участников группы", validatorMusicBandNumberOfParticipants),
            longCollector.ask("Кол-во альбомов группы", validatorMusicBandAlbumsCount),
            builderMusicGenre.build(),
            builderPerson.build()
        )
        musicBand.name = newMusicBand.name
        musicBand.coordinates = newMusicBand.coordinates
        musicBand.numberOfParticipants = newMusicBand.numberOfParticipants
        musicBand.albumsCount = newMusicBand.albumsCount
        musicBand.genre = newMusicBand.genre
        musicBand.frontMan = newMusicBand.frontMan
    }
}