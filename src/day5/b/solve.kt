package day5.b

import java.io.File
import kotlin.math.max
import kotlin.math.min

data class Range(var lo: Long, var hi: Long) {
    fun inRange(x: Long): Boolean {
        return x >= lo && x <= hi
    }

    fun size(): Long {
        return hi - lo + 1
    }

    fun mergeWith(other: Range): Range {
        val newLo = min(lo, other.lo)
        val newHi = max(hi, other.hi)
        return Range(newLo, newHi)
    }
}

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()
    var ranges: MutableList<Range> = mutableListOf()
    val products: MutableList<Long> = mutableListOf()
    lines.forEach { line ->
        if (line.contains("-")) {
            var parts = line.split("-")
            ranges.add(Range(parts[0].toLong(), parts[1].toLong()))
        } else if (!line.isEmpty()) {
            products.add(line.toLong())
        }
    }
    var rangeMerged = true
    while (rangeMerged) {
        rangeMerged = false
        val mergedRanges: MutableList<Range> = mutableListOf()
        for (range in ranges) {
            var matchFound = false
            mergedRanges.forEach { other ->
                if (other.inRange(range.lo) || other.inRange(range.hi) || range.inRange(other.lo) || range.inRange(
                        other.hi
                    )
                ) {
                    val merged = range.mergeWith(other)
                    other.lo = merged.lo
                    other.hi = merged.hi
                    rangeMerged = true
                    matchFound = true
                }
            }
            if (!matchFound) {
                mergedRanges.add(range)
            }
        }
        ranges = mergedRanges
    }
    ranges.forEach { range ->
        println(range)
        result += range.size()
    }
    return result
}

fun main() {
//    println("the answer = " + solve("src/day5/sample.txt"))
    println("the answer = " + solve("src/day5/input.txt"))
}
