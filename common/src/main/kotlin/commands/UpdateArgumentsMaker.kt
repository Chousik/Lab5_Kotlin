package commands

import collection.builder.BuilderMusicBand
import scanners.MyScanners
import java.util.*

class UpdateArgumentsMaker: MakerArguments<Array<Any>>(1) {
    override fun make(arguments: Array<String>, scanner: MyScanners): Array<Any> {
        return arrayOf(arguments[0].toInt(), BuilderMusicBand(scanner).build())
    }

}