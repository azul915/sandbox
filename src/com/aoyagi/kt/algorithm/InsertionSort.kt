package com.aoyagi.kt.algorithm

fun main() {
    val a = intArrayOf(90, 34, 78, 12, 56)

    for (ins in 1 until a.size) {
        val temp = a[ins]
        for (cmp in ins - 1 downTo 0) {
            if (a[cmp] > temp) {
                a[cmp + 1] = a[cmp]
                a[cmp] = temp
            }
        }
    }
    a.forEach { print("[$it] ") }
}