package day5.a

import java.io.File

data class Range(val lo: Long, val hi: Long) {
    fun in_range(x: Long): Boolean {
        return x >= lo && x <= hi
    }
}

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()
    val ranges: MutableList<Range> = mutableListOf()
    val products: MutableList<Long> = mutableListOf()
    lines.forEach { line ->
        if (line.contains("-")) {
            var parts = line.split("-")
            ranges.add(Range(parts[0].toLong(), parts[1].toLong()))
        } else if (!line.isEmpty()) {
            products.add(line.toLong())
        }
    }
    products.forEach { product ->
        var isFresh = false
        ranges.forEach { range ->
            if (range.in_range(product)) {
                isFresh = true
            }
        }
        if (isFresh) {
            result++
        }
    }
    return result
}

fun main() {
    println("the answer = " + solve("src/day5/sample.txt"))
//    println("the answer = " + solve("src/day5/input.txt"))
}
