package com.aoyagi.kt.old

fun factorial(n: Int): Int {
    return if (n == 0) 1 else n * factorial(n - 1)
}

fun main(args: Array<String>) {
    val ans: Int = factorial(5)
    println(ans)
}