package com.jerry.algorithm

/**
 *
 * @author chenjingxin
 */

fun swap(array: CharArray, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

fun swap(array: IntArray, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

//fun swap1(array: CharArray, i: Int, j: Int) {
//    array[i] = array[i]
//
//}

fun show(a: IntArray) {
    a.forEach {
        print(it.toString().plus("-"))
    }
    println()
}
