package day3.a

import java.io.File

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
        val len = line.length
        var maxLoPos = 0
        var maxLoVal = line[0].digitToInt()
        for (lo in 1..len - 2) {
            val v = line[lo].digitToInt()
            if (v > maxLoVal) {
                maxLoPos = lo
                maxLoVal = v
            }
        }
        var maxHiPos = maxLoPos + 1
        var maxHiVal = line[maxHiPos].digitToInt()
        for (hi in maxLoPos+1..len - 1) {
            val v = line[hi].digitToInt()
            if (v > maxHiVal) {
                maxHiPos = hi
                maxHiVal = v
            }
        }
        val joltage = 10 * maxLoVal + maxHiVal
        println("Joltage for this row: $joltage")
        result += joltage
    }
    return result
}

fun main(args: Array<String>) {
//    println("the answer = " + solve("src/day3/sample.txt"))
    println("the answer = " + solve("src/day3/input.txt"))
}
