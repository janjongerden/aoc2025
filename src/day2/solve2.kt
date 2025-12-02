package day2
import java.io.File


fun isInvalid2(productId: Long): Boolean {
    val idString = productId.toString()
    val len = idString.length

    for (i in 1.. len / 2) {
        if (len % i != 0) continue

        val pattern = idString.substring(0, i)
        if (pattern.repeat(len / i) == idString) return true
    }
    return false
}

fun solve2(file: String): Long {
    var idSum = 0L
    val lines = File(file).readLines()

    lines.forEach { line ->
        val ranges = line.split(",")
        ranges.forEach { range ->
            val (startString, endString) = range.split("-")
            val start = startString.toLong()
            val end = endString.toLong()
            for (productId in start..end) {
                if (isInvalid2(productId)) {
                    idSum += productId
                }
            }
        }
    }
    return idSum
}

fun main(args: Array<String>) {
//    println("the answer = " + solve2("src/day2/sample.txt"))
    println("the answer = " + solve2("src/day2/input.txt"))
}
