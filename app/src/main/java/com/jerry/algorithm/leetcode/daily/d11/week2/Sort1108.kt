package com.jerry.algorithm.leetcode.daily.d11.week2

import com.jerry.algorithm.show
import com.jerry.algorithm.showArray

/**
 *
 * @author chenjingxin
 */

fun main() {
    val nums = intArrayOf(6,4,7,5,3,1,2)
    selection(nums)
//    insertion(nums)
    show(nums)
}

fun selection(array: IntArray) {
    (0 until array.lastIndex).forEach { i ->
        // 设置锚点，记录最小值
        var min = i
        (i+1).rangeTo(array.lastIndex).forEach { j ->
            // 循环后面元素，都与 min 比较，如果 min 大于 j，则修改 min 的值
            if (array[j] < array[min]) {
                min = j
            }
        }
        // 说明 i 不是最小值，min 是最小值，交换元素
        if (i != min) {
            val temp = array[i]
            array[i] = array[min]
            array[min] = temp
        }
    }
}

private fun insertion(array: IntArray) {
    1.rangeTo(array.lastIndex).forEach { i ->
        (i downTo 1).forEach { j ->
            if (array[j] < array[j-1]) {
                val temp = array[j]
                array[j] = array[j-1]
                array[j-1] = temp
            }
        }
    }
}

private fun quickSort(array: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val pivot = partition(array, start, end)
    quickSort(array, start, pivot - 1)
    quickSort(array, pivot + 1, end)
}

private fun partition(array: IntArray, start: Int, end: Int): Int {
    val pivot = array[start]
    var left = start
    var right = end
    while (left != right) {
        while (right > left && array[right] > pivot) {
            right--
        }
        while (left < right && array[left] < pivot) {
            left--
        }
        if (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
        }
    }
    array[start] = array[left]
    array[left] = pivot
    return left
}


