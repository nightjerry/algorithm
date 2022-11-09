package com.jerry.algorithm.leetcode.daily.d11

import com.jerry.algorithm.show

/**
 *
 * @author chenjingxin
 */

fun main() {
    val nums = intArrayOf(4,5,6,1,2,3,7,8)
    quickSort(nums, 0, nums.lastIndex)
//    bubbleSort(nums)
    show(nums)
}

private fun quickSort(array: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val pivot = partition(array, start, end)
    println("pivot = $pivot")
    quickSort(array, start, pivot - 1)
    quickSort(array, pivot + 1, end)
}

private fun partition1(array: IntArray, start: Int, end: Int): Int {
    var left = start
    var right = end + 1
    val pivot = array[start]
    // TODO
    return left
}

private fun partition(array: IntArray, start: Int, end: Int): Int {
    val pivot = array[start]
    var left = start
    var right = end
    while (left != right) {
        while (left < right && array[right]> pivot) {
            right--
        }
        while (left < right && array[left] <= pivot) {
            left++
        }
        if (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
        }
    }
    println("left = $left, right = $right")
    array[start] = array[left]
    array[left] = pivot

    return left
}

/**
 * 冒泡排序
 * 每次找出数组最大值
 * 每次都和后一位对比
 */
private fun bubbleSort(array: IntArray) {
    (0 until array.lastIndex).forEach { i ->
        (0 until array.lastIndex - i).forEach { j ->
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

/**
 * 鸡尾酒排序
 */
private fun cocktailSort(array: IntArray) {
    var temp: Int
    run {
        // 外层循环遍历一半
        (0 until array.lastIndex / 2).forEach { i ->
            var isSorted = true
            // a. 内层有左到右开始逐个遍历，
            (i until array.lastIndex - i).forEach { j ->
                if (array[j] > array[j + 1]) {
                    temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                    isSorted = false
                }
            }
            // 如果没有修改，说明已经有序，结束循环
            if (isSorted) {
                return@run
            }
            isSorted = true
            // b. 从右向左开始逐个遍历，
            (array.lastIndex - i downTo i + 1).forEach { k ->
                if (array[k] < array[k - 1]) {
                    temp = array[k]
                    array[k] = array[k - 1]
                    array[k - 1] = temp
                    isSorted = false
                }
            }
            // 如果没有修改，说明已经有序，结束循环
            if (isSorted) {
                return@run
            }

            show(array)
            println("--------")
        }
    }
}
