import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createDirectory

fun solveFile(day: Int): String {
    return """package day${day}.a

import java.io.File

var lines: List<String> = emptyList()

var height = -1
var width = -1

fun readInput(file: String) {
    lines = File(file).readLines()
    height = lines.size
    width = lines[0].length
}

fun solve(): Long {
    var result = 0L

    lines.forEach { line ->
    }
    return result
}

fun main() {
    readInput("src/day${day}/sample.txt")
//    readInput("src/day${day}/input.txt")
    
    println("the answer = " + solve())
}
"""
}

fun main() {
    for (day in 8..12) {
        Path("src/day$day").createDirectory()
        Path("src/day$day/a").createDirectory()
        Path("src/day$day/b").createDirectory()
        File("src/day${day}/sample.txt").createNewFile()
        File("src/day${day}/input.txt").createNewFile()
        File("src/day${day}/a/solve.kt").writeText(solveFile(day))
    }
}
