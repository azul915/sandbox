package com.aoyagi.kt

data class StationList(var name: String, var next: Int)

var list = arrayOfNulls<StationList>(5)

var top = 2

fun main(args: Array<String>) {
    initStationList()
    printStationList()
}

fun initStationList() {
    list[0] = StationList("新大阪", -1)
    list[1] = StationList("名古屋", 3)
    list[2] = StationList("東京", 4)
    list[3] = StationList("京都", 0)
    list[4] = StationList("新横浜", 1)


}

fun printStationList() {

    var idx = top
    while(idx != -1) {
        print("[${list[idx]?.name}]->")
        idx = list[idx]?.next!!
    }
    println("")
}

/*
@args insIdx 挿入する添字
@args insName 挿入する名前
@args preIdx 前の添字
 */
fun insertStationList(insIdx: Int, insName: String, prevIdx: Int) {
    list[insIdx]?.name = insName
    list[insIdx]?.next = list[prevIdx]?.next!!
    list[prevIdx]?.next = insIdx
}

/*
@args delIdx 削除する要素の添字
@args prevIdx 前の添字
 */
fun deleteStationList(delIdx: Int, prevIdx: Int) {
    list[delIdx]?.next = list[prevIdx]?.next!!
}