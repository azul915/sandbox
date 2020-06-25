package com.aoyagi.kt.algorithm

fun main() {
    val a = intArrayOf(39,41,53,55,68,72,84,88,92,97)
    val x = readLine()!!.toInt()
    println("x = $x")
    var pos = -1
    var left = 0
    var right = 9
    var middle: Int
    while (pos == -1 && left <= right) {
        middle = (left + right) / 2
        if (a[middle] == x) {
            pos = middle
            break
        } else if (a[middle] > x) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }
    println("pos = $pos")
}
