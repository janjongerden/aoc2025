package day1
import java.io.File

fun solve(file: String): Long {
    var pos = 50
    var zeros = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
        val clicks = line.substring(1).toInt()
        if (line.startsWith("L")) {
            pos -= clicks
        } else {
            pos += clicks
        }
        pos = (pos + 100) % 100
        if (pos == 0) {
            zeros++
        }
    }
    return zeros
}

fun main(args: Array<String>) {
//    println("the answer = " + solve("src/day1/sample.txt"))
    println("the answer = " + solve("src/day1/input.txt"))
}
