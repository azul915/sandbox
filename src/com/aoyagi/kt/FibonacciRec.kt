package com.aoyagi.kt

fun fibonacci(n: Int): Int {
    return if(n <= 1) {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}

fun main(args: Array<String>) {
    for(n in 0..8) {
        print("${fibonacci(n)}, ")
    }
    println("")
}