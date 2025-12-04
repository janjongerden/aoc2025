package day4.b

import java.io.File

fun solve(file: String): Long {
    var result = 0L
    val lines = File(file).readLines()
    val h = lines.size
    val w = lines[0].length

    val grid = Array(w + 2) { IntArray(h + 2) }
    for (i in 1..w) {
        for (j in 1..h) {
            if (lines[j - 1][i - 1] == '@') {
                grid[j][i] = 1
            }
        }
    }

    var removedRoll = true
    while (removedRoll) {
        removedRoll = false
        for (i in 1..w) {
            for (j in 1..h) {
                if (grid[i][j] == 1) {
                    var adjacent = 0
                    adjacent += (grid[i - 1][j - 1])
                    adjacent += (grid[i - 1][j])
                    adjacent += (grid[i - 1][j + 1])
                    adjacent += (grid[i][j - 1])
                    adjacent += (grid[i][j + 1])
                    adjacent += (grid[i + 1][j - 1])
                    adjacent += (grid[i + 1][j])
                    adjacent += (grid[i + 1][j + 1])
                    if (adjacent < 4) {
                        removedRoll = true
                        grid[i][j] = 0
                        result++
                    }
                }
            }
        }
    }
    return result
}

fun main() {
//    println("the answer = " + solve("src/day4/sample.txt"))
    println("the answer = " + solve("src/day4/input.txt"))
}
