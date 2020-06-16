package com.aoyagi.kt.algorithm

// a と ｂに格納された整数の最大公約数を求める
fun main() {
    var (a, b) = readLine()!!.split(" ").map { it.toInt() }

    while (a != b) {
        if (a > b) {
            a -= b
        } else {
            b -= a
        }
    }

    println(a)
}