package day7.b

import java.io.File

var lines: MutableList<MutableList<Char>> = mutableListOf()

var height = -1
var width = -1

fun readInput(file: String) {
    val strings = File(file).readLines()
    lines = mutableListOf<MutableList<Char>>()
    for (line in strings) {
        var charLine = mutableListOf<Char>()
        for (i in 0..line.length - 1) {
            var c = line[i]
            if (c == 'S') {
                c = '|'
            }
            charLine.add(c)
        }
        lines.add(charLine)
    }
    height = lines.size
    width = lines[0].size
}

fun solve(): Long {
    var result = 0L

    val pathCounter: Array<Long> = Array(width) {0L}
    pathCounter[lines[0].indexOfFirst { it == '|' }] = 1L

    for (y in 1..height - 1) {
        val line = lines[y]
        for (x in 0..width - 1) {
            val char = line[x]

            val isBeam = lines[y - 1][x] == '|'
            if (isBeam) {
                if (char == '^') {
                    line[x - 1] = '|'
                    line[x + 1] = '|'
                    val oldPathCount = pathCounter[x]
                    pathCounter[x] = 0L
                    pathCounter[x - 1] += oldPathCount
                    pathCounter[x + 1] += oldPathCount
                } else {
                    line[x] = '|'
                }
            }
        }
    }

    return pathCounter.sum()
}

fun main() {
//    readInput("src/day7/sample.txt")
    readInput("src/day7/input.txt")

    println("the answer = " + solve())
}
