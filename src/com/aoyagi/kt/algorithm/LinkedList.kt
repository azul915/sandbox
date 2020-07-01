package com.aoyagi.kt.algorithm

data class Station(val name: String, val next: Int)

fun main() {
   val stationList= arrayOf(
           Station(name = "新大阪", next = -1),
           Station(name = "名古屋", next = 3),
           Station(name = "東京", next = 4),
           Station(name = "京都", next = 0),
           Station(name = "新横浜", next = 1))
    val top = 2
    var index = top
    for (i in stationList.indices) {
        print("${stationList[index].name}->")
        index = stationList[index].next
    }
}