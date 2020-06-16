package com.aoyagi.kt.old

var fibonacciNumbers = arrayOfNulls<Int>(100)

// フィボナッチ数を記憶する配列を初期化するメソッド
fun initfibonacciNumbers() {
    for (i in fibonacciNumbers.indices) {
        fibonacciNumbers[i] = -1
    }
}

// 引数nのフィボナッチ数を返すメソッド
//fun fibonacci(n: Int): Int {
//    println("fibonacci(${n})が呼ばれました。")
//
//    if(fibonacciNumbers[n] == -1) {
//        if(n <= 1) {
//            fibonacciNumbers[n] = n
//        } else {
//            fibonacciNumbers[n] = fibonacci(n - 1) + fibonacci(n - 2)
//        }
//
//        return fibonacciNumbers[n]!!
//    }
//}

fun main(args: Array<String>) {
    initfibonacciNumbers()
    print(fibonacciNumbers[0])
//    print("5番目のフィボナッチ数 = ${fibonacci(5)!!}")
}