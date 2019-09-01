package com.aoyagi.kt

fun main(args: Array<String>) {

    var list = arrayOfNulls<StationList>(5)

    list[0] = StationList("新大阪", -1)
    list[1] = StationList("名古屋", 3)
    list[2] = StationList("東京", 4)
    list[3] = StationList("京都", 0)
    list[4] = StationList("新横浜", 1)

    val top = 2

    var idx = top
    while (idx != -1) {
        print("[${list[idx]?.name}]->")
        idx = list[idx]?.next!!
    }
    println("")


}

data class StationList(var name: String, var next: Int)


fun initStationList() {

}

fun printStationList() {


}

/*
@args insIdx 挿入する添字
@args insName 挿入する名前
@args preIdx 前の添字
 */
fun insertStationList(insIdx: Int, insName: String, prevIdx: Int) {
    list[insIdx]?.name = insName
    list[insIdx]?.next = list[prevIdx]?.next
    list[prevIdx]?.next = insIdx
}

fun deleteStationList(delIdx: Int, prevIdx: Int) {
    list[delIdx]?.next = list[prevIdx]?.next
}