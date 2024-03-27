package scanners

import java.util.Scanner

abstract class Scanners(private var scan: Scanner){
    fun hasNext(): Boolean{
        return scan.hasNext();
    }
    fun nextLine(): String{
        return scan.nextLine()
    }
}