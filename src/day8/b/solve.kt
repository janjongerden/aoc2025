package day8.b

import java.io.File
import java.util.*
import kotlin.math.sqrt

fun sqr(f: Long): Float {
    return (f * f).toFloat()
}

data class Box(val x: Long, val y: Long, val z: Long) {

    var networkId = -1

    fun dist(other: Box): Double {
        return sqrt((sqr(x - other.x) + sqr(y - other.y) + sqr(z - other.z)).toDouble())
    }
}

var lines: List<String> = emptyList()
val boxes: MutableList<Box> = mutableListOf()

var height = -1
var width = -1

fun readInput(file: String) {
    lines = File(file).readLines()
    height = lines.size
    width = lines[0].length

    lines.forEach { line ->
        val (x, y, z) = line.split(",").map { it.toLong() }
        val box = Box(x, y, z)
        boxes.add(box)
    }
}

fun allBoxesConnected(): Boolean {
    val id = boxes[0].networkId
    boxes.forEachIndexed { index, box ->
        if (index > 0) {
            if (box.networkId != id) {
                return false
            }
        }
    }
    return true
}

fun solve(): Long {
    var networkCount = 0

    val distances: MutableMap<Double, Pair<Box, Box>> = TreeMap<Double, Pair<Box, Box>>()

    boxes.forEachIndexed { index, box ->
        boxes.forEachIndexed { index2, other ->
            if (index < index2) {
                distances[box.dist(other)] = Pair(box, other)
            }
        }
    }
    for (entry in distances.entries) {
        val (box1, box2) = entry.value
        if (box1.networkId == -1 && box2.networkId == -1) {
            // new network
            box1.networkId = networkCount
            box2.networkId = networkCount
            networkCount++
        } else if (box1.networkId != box2.networkId) {
            // merge networks
            if (box1.networkId == -1) {
                box1.networkId = box2.networkId
            } else if (box2.networkId == -1) {
                    box2.networkId = box1.networkId
            } else {
                networkMerge(box1.networkId, box2.networkId)
            }
        }
        if (allBoxesConnected()) {
            return box1.x * box2.x
        }
    }
    return -1L
}

fun networkMerge(oldId: Int, newId: Int) {
    boxes.forEach { box ->
        if (box.networkId == oldId) {
            box.networkId = newId
        }
    }
}

fun main() {
//    readInput("src/day8/sample.txt")
    readInput("src/day8/input.txt")
    
    println("the answer = " + solve())
}
