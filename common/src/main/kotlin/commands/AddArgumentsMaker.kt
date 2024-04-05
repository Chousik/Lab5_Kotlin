package commands

import collection.MusicBand
import collection.builder.BuilderMusicBand
import scanners.MyScanners

class AddArgumentsMaker : MakerArguments<MusicBand>(0) {
    override fun make(
        arguments: Array<String>,
        scanner: MyScanners,
    ): MusicBand {
        validCounts(arguments.size)
        return BuilderMusicBand(scanner).build()
    }
}
