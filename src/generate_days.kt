import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createDirectory

fun solveFile(day: Int): String {
    return """package day${day}.a

import java.io.File

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
    }
    return result
}

fun main(args: Array<String>) {
    println("the answer = " + solve("src/day${day}/sample.txt"))
//    println("the answer = " + solve("src/day${day}/input.txt"))
}
"""
}

fun main() {
    for (day in 3..12) {
        Path("src/day$day").createDirectory()
        Path("src/day$day/a").createDirectory()
        Path("src/day$day/b").createDirectory()
        File("src/day${day}/sample.txt").createNewFile()
        File("src/day${day}/input.txt").createNewFile()
        File("src/day${day}/a/solve.kt").writeText(solveFile(day))
    }
}
