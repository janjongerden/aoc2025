package day9.b

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

var inputLines: List<String> = emptyList()

var height = -1
var width = -1

fun readInput(file: String) {
    inputLines = File(file).readLines()
    height = inputLines.size
    width = inputLines[0].length
}

data class Point(val x: Long, val y: Long)

fun solve(): Long {
    var biggest = 0L

    val tiles: MutableList<Point> = mutableListOf()
    inputLines.forEach { line ->
        val (x, y) = line.split(",")
        tiles.add(Point(x.toLong(), y.toLong()))
    }
    val lines: MutableList<Pair<Point, Point>> = mutableListOf()
    lines.add(Pair(tiles[0], tiles[tiles.size - 1]))
    for (i in 0..tiles.lastIndex - 2) {
        lines.add(Pair(tiles[i], tiles[i + 1]))
    }
    tiles.forEachIndexed { index1, tile1 ->
        tiles.forEachIndexed { index2, tile2 ->
            if (index2 > index1) {
                var allowed = true
                lines.forEach { line ->
                    if (crossesRectangle(tile1, tile2, line)) {
                        allowed = false
                    }
                }
                if (allowed) {
                    val size = abs(tile1.x - tile2.x + 1) * abs(tile1.y - tile2.y + 1)
                    if (size > biggest) {
                        biggest = size
                    }
                }
            }
        }
    }
    return biggest
}

fun crossesRectangle(tile1: Point, tile2: Point, line: Pair<Point, Point>): Boolean {
    val lineStart = line.first
    val lineEnd = line.second
    // if the midpoint of one of the lines is inside the rectangle, the rectangle contains non-red/green tiles
    return pointInside(tile1, tile2, Point((lineStart.x + lineEnd.x)/2, (lineStart.y + lineEnd.y)/2))
}

fun pointInside(tile1: Point, tile2: Point, point: Point): Boolean {
    val xMin = min(tile1.x, tile2.x)
    val yMin = min(tile1.y, tile2.y)
    val xMax = max(tile1.x, tile2.x)
    val yMax = max(tile1.y, tile2.y)
    val x = point.x
    val y = point.y

    return x > xMin && x < xMax && y > yMin && y < yMax
}

fun main() {
//    readInput("src/day9/sample.txt")
    readInput("src/day9/input.txt")
    
    println("the answer = " + solve())
}
