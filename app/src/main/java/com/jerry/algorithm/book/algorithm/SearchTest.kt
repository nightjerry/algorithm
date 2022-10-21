package com.jerry.algorithm.book.algorithm

/**
 *
 * @author chenjingxin
 */
object SearchTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(1,2,3,4,5,6,7,8,9)
        val index = binarySearch(array, 5)
        println("index = $index.")
    }

    fun binarySearch(array: IntArray, key: Int): Int {
        var low = 0
        var high = array.lastIndex
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (array[mid] > key) {
                high = mid - 1
            } else if (array[mid] < key) {
                low = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}
