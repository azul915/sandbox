package com.aoyagi.kt

data class StationList(var name: String, var next: Int)

var list = arrayOfNulls<StationList>(10)

const val start = 2

fun main(args: Array<String>) {
    initStationList()
    printStationList()

    insertStationList(5, "品川", 2)
    printStationList()

    deleteStationList(5, 2)
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
    var idx = start
    while(idx != -1) {
        print("[${list[idx]?.name!!}]->")
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
    list[insIdx] = StationList(insName, list[prevIdx]?.next!!)
    list[prevIdx] = StationList(list[prevIdx]?.name!!, insIdx)
}

/*
@args delIdx 削除する添字
@args preIdx 前の添字
 */
fun deleteStationList(delIdx: Int, prevIdx: Int) {
    list[prevIdx] = StationList(list[prevIdx]?.name!!, list[delIdx]?.next!!)
}