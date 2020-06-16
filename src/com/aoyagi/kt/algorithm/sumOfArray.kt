package com.aoyagi.kt.algorithm

fun main() {
    val a = intArrayOf(72, 68, 92, 88, 41, 53, 97, 84, 39, 55)
    var sum = 0
    for (i in a.indices) {
        sum += a[i]
    }

    println("sum = $sum")

}