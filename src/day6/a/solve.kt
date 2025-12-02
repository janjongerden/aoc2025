package day6.a

import java.io.File

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
    }
    return result
}

fun main(args: Array<String>) {
    println("the answer = " + solve("src/day6/sample.txt"))
//    println("the answer = " + solve("src/day6/input.txt"))
}
