import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createDirectory

fun solveFile(day: Int): String {
    return """package day${day}

import java.io.File

fun solve(file: String): Long {
    val result = 0L
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
        File("src/day${day}/sample.txt").createNewFile()
        File("src/day${day}/input.txt").createNewFile()
        File("src/day${day}/solve.kt").writeText(solveFile(day))
    }
}
