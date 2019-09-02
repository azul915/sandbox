package com.aoyagi.kt

data class BST(var data: Int, var left: Int, var right: Int)

var tree = arrayOfNulls<BST>(10)

// 根の要素の添字(連結リストの先頭ポインタ)
const val rootIdx = 0

// 次に格納する要素の添字
var newIdx = 0

fun main(args: Array<String>) {

    for(i in tree.indices) tree[i] = BST(0, -1, -1)

    addBST(4)
    addBST(6)
    addBST(5)
    addBST(2)
    addBST(3)
    addBST(7)
    addBST(1)
    printPhysicalBST()
}

fun addBST(data: Int) {

    tree[newIdx] = BST(data, -1, -1)

    if(newIdx != rootIdx) {
        var currentIdx = rootIdx
        var finished = false

        do {
            if(data < tree[currentIdx]?.data!!) {
                if (tree[currentIdx]?.left == -1) {
                    tree[currentIdx] = BST(data, newIdx, -1)
                    finished = true
                } else {
                    currentIdx = tree[currentIdx]?.left!!
                }
            } else {
                if(tree[currentIdx]?.right == -1) {
                    tree[currentIdx] = BST(data, -1, newIdx)
                    finished = true
                } else {
                    currentIdx = tree[currentIdx]?.right!!
                }
            }
        } while (!finished)
    }

    newIdx++
}

fun printPhysicalBST() {

    for (i in 0..newIdx) {
        println("tree[${i}] : data = ${tree[i]?.data}, left = ${tree[i]?.left}, right = ${tree[i]?.right}")
    }

}