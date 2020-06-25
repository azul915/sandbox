package com.aoyagi.kt.algorithm

fun main() {
    val a = intArrayOf(72, 68, 92, 88, 41, 53, 97, 84, 39, 55)
    var pos = -1
    for (i in a.indices) {
        if (a[i] == 53) {
            pos = i
            break
        }
    }
    println(pos)
}
