package collection.builder

import collection.MusicBand
import collection.builder.collectors.LongCollector
import collection.builder.collectors.StringCollector
import collection.validators.ValidatorMusicBandAlbumsCount
import collection.validators.ValidatorMusicBandName
import collection.validators.ValidatorMusicBandNumberOfParticipants
import scanners.MyScanners
import java.io.Serializable
import java.util.*


class BuilderMusicBand(private val scanner: MyScanners) : IBuilder<MusicBand>, Serializable {
    private val validatorMusicBandName: ValidatorMusicBandName = ValidatorMusicBandName()
    private val validatorMusicBandAlbumsCount: ValidatorMusicBandAlbumsCount = ValidatorMusicBandAlbumsCount()
    private val validatorMusicBandNumberOfParticipants: ValidatorMusicBandNumberOfParticipants = ValidatorMusicBandNumberOfParticipants()
    private val builderCoordinates: BuilderCoordinates = BuilderCoordinates(scanner)
    private val builderPerson = BuilderPerson(scanner)
    private val builderMusicGenre = BuilderMusicGenre(scanner)
    private val stringCollector = StringCollector(scanner)
    private val longCollector = LongCollector(scanner)



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


    fun reBuild(musicBandOld: MusicBand, musicBandNew: MusicBand) {
        musicBandOld.name = musicBandNew.name
        musicBandOld.coordinates = musicBandNew.coordinates
        musicBandOld.numberOfParticipants = musicBandNew.numberOfParticipants
        musicBandOld.albumsCount = musicBandNew.albumsCount
        musicBandOld.genre = musicBandNew.genre
        musicBandOld.frontMan = musicBandNew.frontMan
    }
}