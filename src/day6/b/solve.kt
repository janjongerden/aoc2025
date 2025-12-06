package day6.b

import java.io.File

var lines: List<String> = emptyList()

// max width/length of a number
var numWidth = -1

fun allSpace(index: Int): Boolean {
    for (i in 0..numWidth - 1) {
        if (lines[i][index] != ' ') {
            return false
        }
    }
    return true
}

fun numAt(index: Int): Long {
    var numString = ""
    for (i in 0..numWidth - 1) {
        numString += lines[i][index]
    }
    return numString.trim().toLong()
}

fun solve(file: String): Long {
    var result = 0L
    lines = File(file).readLines()
    numWidth = lines.size - 1

    var operators: List<String> = emptyList()
    lines.forEach { line ->
        if (line.startsWith("*")) {
            operators = line.split("\\s+".toRegex())
        }
    }
    var index = 0
    operators.forEach { op ->
        val mul = op == "*"
        var columnResult: Long = if (mul) 1 else 0
        while (index < lines[0].length && !allSpace(index) )  {
            if (mul) {
                println("numat $index = ${numAt(index)}")
                columnResult *= numAt(index)
            } else {
                columnResult += numAt(index)
            }
            index++
        }
        index++
        println("adding $columnResult")
        result += columnResult
    }
    return result
}

fun main() {
//    println("the answer = " + solve("src/day6/sample.txt"))
    println("the answer = " + solve("src/day6/input.txt"))
}
