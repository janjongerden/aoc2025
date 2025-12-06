package day8.a

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
    readInput("src/day8/sample.txt")
//    readInput("src/day8/input.txt")
    
    println("the answer = " + solve())
}
