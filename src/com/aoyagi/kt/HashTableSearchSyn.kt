package com.aoyagi.kt

import java.util.Scanner

var hashTable = intArrayOf(
        -1,
        -1,
        -1,
        -1,
        -1,
        -1,
        -1,
        -1,
        -1,
        -1
)

fun hashFunc(data: Int): Int {
    return data % 10
}

fun main(args: Array<String>) {
    var data: Int
    var hashValue: Int
    var pos: Int

    var scn: Scanner = Scanner(System.`in`)

    do {
        // 格納するデータを入力する
        print("格納するデータ = ")
        var data = scn.nextInt()

        // マイナスの値が入力されたらデータの格納を終了する
        if (data < 0) break

        // ハッシュ値を求める
        hashValue = hashFunc(data)
        println("ハッシュ値 = $data % 10 = $hashValue")

        // データの格納位置を決める
        pos = hashValue
        println("格納位置pos = $pos")

        while (hashTable[pos] != -1) {
            pos++

            // 末尾を超えたら先頭に戻す
            if (pos >= hashTable.size) pos = 0
            println("格納位置pos = $pos")

            // ハッシュ値の位置まで戻ったら、ハッシュ値がいっぱいなので、繰り返しを終了する
            if (pos == hashValue) break
        }


        if (hashTable[pos] == -1) {
            // ハッシュ表が一杯でなければ、データを格納する
            hashTable[pos] = data
            println("hashTable[${pos}] に${data}を格納する。")
        } else {
            println("ハッシュ値が一杯です。")
        }
    } while (true)


    // ハッシュ表からデータをサーチする
    do {
        print("サーチするデータ = ")
        var data = scn.nextInt()

        if (data < 0) break

        hashValue = hashFunc(data)

        println("ハッシュ値 = $data %% 10 = $hashValue")

        // データをサーチする
        pos = hashValue

        println("探索位置pos = $pos")

        while (hashTable[pos] == -1 && hashTable[pos] != data) {
            // 探索位置を1つ先に進める
            pos++

            // 末尾が見えたら先頭に戻す
            if (pos >= hashTable.size) pos = 0

            println("探索位置pos = $pos")

            // -1を見つけるか、またはハッシュ値の位置まで戻ったら、
            // データが見つからないことが確定なので、繰り返しを終了する
            if (hashTable[pos] == -1 || pos == hashValue) break
        }

        // サーチした結果を表示する
        if (hashTable[pos] == data) {
            println("hashTable[${pos}]の値は${hashTable[pos]}なので、見つかった位置を表示する。")
            println("${pos}番目に見つかりました。")
        } else {
            println("hashTable[${pos}]も値は${hashTable[pos]}なので、「見つかりません。」を表示する。")
            println("見つかりません。")
        }
    } while (true)
}

