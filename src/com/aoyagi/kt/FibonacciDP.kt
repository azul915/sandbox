val fibonacciNumbers = arrayOfNulls<Int>(100)

fun fibonacci(n: Int): Int? {
    for (i in 0..n) {
        if(i <= 1) {
            fibonacciNumbers[i] = i
        } else {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1]!! + fibonacciNumbers[i - 2]!!
        }
    }
    return fibonacciNumbers[n]
}

fun main(args: Array<String>) {
    for(n in 0..8) {
        print("${fibonacci(n)}, ")
    }
    println("")
}