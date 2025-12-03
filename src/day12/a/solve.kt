package day12.a

import java.io.File

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
    }
    return result
}

fun main() {
    println("the answer = " + solve("src/day12/sample.txt"))
//    println("the answer = " + solve("src/day12/input.txt"))
}
