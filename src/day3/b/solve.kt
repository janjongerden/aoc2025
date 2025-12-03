package day3.b

import java.io.File
import kotlin.math.pow

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
        val len = line.length
        var joltage = 0L
        var linePointer = 0
        for (rank in 12 downTo 1) {
            val maxPos = maxPosInRange(line, linePointer, len - rank)
            val maxVal = line[maxPos].digitToInt().toLong()
            joltage += maxVal * 10.0.pow(rank - 1.0).toLong()
            linePointer = maxPos + 1
        }
        println("Joltage for this row: $joltage")
        result += joltage
    }
    return result
}

fun maxPosInRange(line: String, lo: Int, hi: Int): Int {
    var maxPos = lo
    var maxVal = line[lo].digitToInt()
    for (pos in lo..hi) {
        val v = line[pos].digitToInt()
        if (v > maxVal) {
            maxPos = pos
            maxVal = v
        }
    }
    return maxPos
}

fun main() {
//    println("the answer = " + solve("src/day3/sample.txt"))
    println("the answer = " + solve("src/day3/input.txt"))
}
