package scanners

import java.io.File
import java.util.Scanner

class FileScanner(file: File) : MyScanners(Scanner(file))
