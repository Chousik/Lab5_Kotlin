package scanners

import java.io.File
import java.util.*

class FileScanner(file: File): MyScanners(Scanner(file))