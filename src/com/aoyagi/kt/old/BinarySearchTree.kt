package com.aoyagi.kt.old

data class BST(var data: Int, var left: Int, var right: Int)

var tree = arrayOfNulls<BST>(10)

// 根の要素の添字(連結リストの先頭ポインタ)
const val rootIdx = 0

// 次に格納する要素の添字
var newIdx = 0

fun main(args: Array<String>) {

    for (i in tree.indices) tree[i] = BST(0, 0, 0)

    addBST(4)
    addBST(6)
    addBST(5)
    addBST(2)
    addBST(3)
    addBST(7)
    addBST(1)
    printPhysicalBST()
    println("---------------------------------------------")
    printLogicalBST(rootIdx)

    println("「5」の探索結果 = ${searchBST(5)}")
    println("「8」の探索結果 = ${searchBST(8)}")
    println("---------------------------------------------")
    println("「5」の探索結果 = ${searchRecBST(5, rootIdx)}")
    println("「8」の探索結果 = ${searchRecBST(8, rootIdx)}")
}

fun addBST(data: Int) {

    tree[newIdx] = BST(data, -1, -1)

    if(newIdx != rootIdx) {
        var currentIdx = rootIdx
        var finished = false

        do {
            if(data < tree[currentIdx]?.data!!) {
                if (tree[currentIdx]?.left == -1) {
                    tree[currentIdx] = BST(tree[currentIdx]?.data!!, newIdx, tree[currentIdx]?.right!!)
                    finished = true
                } else {
                    currentIdx = tree[currentIdx]?.left!!
                }
            } else {
                if(tree[currentIdx]?.right == -1) {
                    tree[currentIdx] = BST(tree[currentIdx]?.data!!, tree[currentIdx]?.left!!, newIdx)
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

    for (i in 0 until newIdx) {
        println("tree[${i}] : data = ${tree[i]?.data}, left = ${tree[i]?.left}, right = ${tree[i]?.right}")
    }

}

// 深さ優先探索
fun printLogicalBST(currentIdx: Int) {

    if (currentIdx != -1) {
        println("tree[${currentIdx}] : data = ${tree[currentIdx]?.data!!}, left = ${tree[currentIdx]?.left!!}, right = ${tree[currentIdx]?.right!!}")

        printLogicalBST(tree[currentIdx]?.left!!)
        printLogicalBST(tree[currentIdx]?.right!!)
    }
}

// 二分探索木の探索
fun searchBST(x: Int): Int {
    var idx = -1
    var currentIdx = rootIdx

    while (currentIdx != -1) {
        if (tree[currentIdx]?.data!! == x) {
            idx = currentIdx
            break
        } else if (tree[currentIdx]?.data!! > x) {
            currentIdx = tree[currentIdx]?.left!!
        } else {
            currentIdx = tree[currentIdx]?.right!!
        }
    }
    return idx
}

// 再帰による二分探索木の探索
fun searchRecBST(x: Int, currentIdx: Int): Int {
    return if (currentIdx == -1) {
        -1
    } else {
        if(tree[currentIdx]?.data!! > x) {
            searchRecBST(x, tree[currentIdx]?.left!!)
        } else {
            searchRecBST(x, tree[currentIdx]?.right!!)
        }
    }
}