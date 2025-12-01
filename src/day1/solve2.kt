package day1

import java.io.File

fun solve2(file: String): Long {
    var pos = 50
    var zeros = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
        val rawClicks = line.substring(1).toInt()
        zeros += rawClicks / 100
        val clicks = rawClicks % 100

        val goLeft = line.startsWith("L")
        if (goLeft) {
            if (pos > 0 && pos <= clicks) {
                zeros++
            }
            pos -= clicks
        } else {
            if (pos + clicks >= 100) {
                zeros++
            }
            pos += clicks
        }
        pos = (pos + 100) % 100
    }
    return zeros
}

fun main(args: Array<String>) {
//    println("the answer = " + solve2("src/day1/sample.txt"))
    println("the answer = " + solve2("src/day1/input.txt"))
}
