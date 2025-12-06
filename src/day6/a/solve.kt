package day6.a

import java.io.File

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()

    val nums: MutableList<MutableList<Long>> = kotlin.collections.mutableListOf<MutableList<Long>>()
    var operators: List<String> = emptyList()
    lines.forEach { line ->
        if (line.startsWith("*")) {
            operators = line.split("\\s+".toRegex())
        } else {
            var numLine = mutableListOf<Long>()
            for (s: String in line.split("\\s+".toRegex())) {
                if (!s.isBlank()) {
                    numLine.add(s.toLong())
                }
            }
            nums.add(numLine)
        }
    }
    operators.forEachIndexed { index, op ->
        if (op == "*") {
            // note: this only works for real input, not for sample, as it has only 3 lines
            result += nums[0][index] * nums[1][index] * nums[2][index] * nums[3][index]
        } else {
            result += nums[0][index] + nums[1][index] + nums[2][index] + nums[3][index]
        }
    }
    return result
}

fun main() {
//    println("the answer = " + solve("src/day6/sample.txt"))
    println("the answer = " + solve("src/day6/input.txt"))
}
