package com.aoyagi.kt



fun main(args: Array<String>) {
    initStationList()
    printStationList()
}

data class StationList(var name: String, var next: Int)

fun initStationList(): Unit {
    val list: Array<StationList?> = arrayOfNulls<StationList>(10)
    for (i in list.indices) {
        list[i] = StationList("",0)
    }

    list[0]?.name = "新大阪"
    list[0]?.next = -1
    list[1]?.name = "名古屋"
    list[1]?.next = 3
    list[2]?.name = "東京"
    list[2]?.next = 4
    list[3]?.name = "京都"
    list[3]?.next = 0
    list[4]?.name = "新横浜"
    list[5]?.next = 1


}

fun printStationList(): Unit {

}