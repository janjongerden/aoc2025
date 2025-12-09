package day9.a

import java.io.File
import kotlin.math.abs

var lines: List<String> = emptyList()

var height = -1
var width = -1

fun readInput(file: String) {
    lines = File(file).readLines()
    height = lines.size
    width = lines[0].length
}

fun solve(): Long {
    var biggest = 0L

    val tiles: MutableList<Pair<Long, Long>> = mutableListOf()
    lines.forEach { line ->
        val (x, y) = line.split(",")
        tiles.add(Pair(x.toLong(), y.toLong()))
    }
    tiles.forEachIndexed { index, tile1 ->
        tiles.forEachIndexed { index2, tile2 ->
            if (index2 > index) {
                var size = abs(tile1.first - tile2.first + 1) * abs(tile1.second - tile2.second + 1)
                if (size > biggest) {
                    biggest = size
                }
            }
        }
    }
    return biggest
}

fun main() {
//    readInput("src/day9/sample.txt")
    readInput("src/day9/input.txt")
    
    println("the answer = " + solve())
}
