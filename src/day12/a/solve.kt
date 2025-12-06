package day12.a

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
    readInput("src/day12/sample.txt")
//    readInput("src/day12/input.txt")
    
    println("the answer = " + solve())
}
