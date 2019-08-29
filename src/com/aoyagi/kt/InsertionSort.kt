package com.aoyagi.kt

fun main(args: Array<String>) {
    val a: Array<Int> = arrayOf(90, 34, 78, 12, 56)

    for (ins in 1 until a.size) {
        val tmp = a[ins]

        for (cmp in ins - 1 downTo 0) {
            if (a[cmp] > tmp) {
                a[cmp + 1] = a[cmp]
                a[cmp] = tmp
            }
        }
    }

    a.forEach { print("[$it]") }

}