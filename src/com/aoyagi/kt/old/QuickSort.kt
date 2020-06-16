package com.aoyagi.kt.old

fun divideArray(a: IntArray, head: Int, tail: Int): Int {

    var temp: Int

    var left = head + 1 // 先頭から+1たどる位置
    var right= tail // 末尾からたどる位置

    //基準値a[head]より小さい要素を前側に、大きい要素を後ろ側に移動する
    while (true) {
        // 配列を先頭+1から後ろに向かってたどり、
        // 基準値より大きい要素を見つける
        while (left < tail && a[head] > a[left]) {
            left++
        }

        // 配列を末尾から前に向かってたどり、
        // 基準値より小さい要素を見つける
        while (a[head] < a[right]) {
            right--
        }

        // チェックする要素がなくなったら終了する
        if(left >= right) {
            break
        }

        //基準値より大きいa[left]とより小さいa[right]を交換する
        temp = a[left]
        a[left] = a[right]
        a[right] = temp

        // 次の要素のチェックに進む
        left++
        right--

    }

    // 基準値a[head]とa[right]を交換する
    temp = a[head]
    a[head] = a[right]
    a[right] = temp

    // 基準値a[right]の位置を返す
    return right
}

fun sortArray(a: IntArray, start: Int, end: Int) {
    var pivot: Int // 配列をグループ分けする基準値の位置

    // 配列の要素が2つ以上あるなら処理を行う
    if(start < end) {
        // 基準値との大小関係に応じてグループ分けする
        pivot = divideArray(a, start, end)

        // 基準値より小さい前側のグループに同じ処理を適用する（再帰呼び出し）
        sortArray(a, start, pivot - 1)

        // 基準値より大きい後ろ側のグループに同じ処理を適用する（再帰呼び出し）
        sortArray(a, pivot + 1, end)

    }
}

// 配列の中身を表示する
fun printArray(a: IntArray) {
    for (i in a.indices) {
        print("[${a[i]}]")
    }
    println("")
}

fun main(args: Array<String>) {
    var a = intArrayOf(4, 7, 1, 6, 2, 5, 3)
    printArray(a)
    sortArray(a, 0, a.size - 1)
    printArray(a)
}