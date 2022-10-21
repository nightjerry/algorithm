package com.jerry.algorithm.book.algorithm

import com.jerry.algorithm.show
import com.jerry.algorithm.swap

/**
 *
 *
 * @author chenjingxin
 */
object SortTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(15, 9, 2, 10, 4, 13, 5, 12, 8, 11, 3, 14, 6, 1, 7)
//        selection(array)
//        insertion(array)
//        shell(array)
        mergeSort(array)
    }

    private lateinit var pq: IntArray

    /**
     * 堆排序
     * 上浮
     */
    fun swim(index: Int) {
        var k = index
        while (k > 1 && pq[k / 2] < pq[k]) {
            var temp = pq[k]
            pq[k] = pq[k / 2]
            pq[k / 2] = temp
            k /= 2
        }
    }

    fun sink(index: Int) {
        var k = index
        while (2 * k <= pq.size) {
            var j = 2 * k
            if (j < pq.size && pq[j] < pq[j+1]) {
                j++
            }
            if (pq[k] < pq[j]) {
                break
            }
            var temp = pq[k]
            pq[k] = pq[j]
            pq[j] = temp
            k = j
        }
    }



    private lateinit var mergeTarget: IntArray

    /**
     * 归并排序
     */
    fun mergeSort(array: IntArray) {
        mergeTarget = IntArray(array.size)
        mergeSort(array, 0, array.lastIndex)
    }

    private fun mergeSort(array: IntArray, start: Int, end: Int) {
        if (end <= start) {
            return
        }
        val mid = start + (end - start) / 2
        // 左半边排序
        mergeSort(array, start, mid)
        // 右半边排序
        mergeSort(array, mid + 1, end)
        merge(array, start, mid, end)
    }

    private fun merge(array: IntArray, start: Int, mid: Int, end: Int) {
        var left = start
        var right = mid + 1
        for (k in start .. end) {
            mergeTarget[k] = array[k]
        }
        for (k in start .. end) {
            when {
                // 左边已取尽，将右边的元素取出
                left > mid -> {
                    array[k] = mergeTarget[right++]
                }
                // 右边已取尽，将左边的元素取出
                right > end -> {
                    array[k] = mergeTarget[left++]
                }
                // 右边 小于 左边，将右边元素取出
                mergeTarget[right] < mergeTarget[left] -> {
                    array[k] = mergeTarget[right++]
                }
                // 右边 大于等于 左边，将左边元素取出
                else -> {
                    array[k] = mergeTarget[left++]
                }
            }
        }
    }

    /**
     * 希尔排序
     */
    fun shell(array: IntArray) {
        var h = 1
        // 合理计算子数组的长度 h
        while (h < array.size / 3) {
            h = 3 * h + 1
        }
        while (h >= 1) {
            for (i in h .. array.lastIndex) {
//                for (j in i downTo h step h) {
//                    if (array[j] < array[j-h]) {
//                        val temp = array[j]
//                        array[j] = array[j-h]
//                        array[j-h] = temp
//                    }
//                }
                var j = i
                while (j >= h && array[j] < array[j-h]) {
                    val temp = array[j]
                    array[j] = array[j-h]
                    array[j-h] = temp
                    j -= h
                }
                show(array)
            }
            h /= 3
        }
    }

    /**
     * 插入排序
     * 不会访问索引右侧元素
     */
    fun insertion(array: IntArray) {
        for (i in 1 .. array.lastIndex) {
            for (j in i downTo 1) {
                // 总是与前面的元素对比，如果当前元素小，则换位置；
                if (array[j] < array[j-1]) {
                    val temp = array[j]
                    array[j] = array[j-1]
                    array[j-1] = temp
                }
            }
//            var j = i
//            while (j > 0 && array[j] < array[j-1]) {
//                val temp = array[j]
//                array[j] = array[j-1]
//                array[j-1] = temp
//                j--
//            }
            show(array)
        }
    }

    /**
     * 选择排序
     * 每次找出数据中最小元素
     */
    fun selection(array: IntArray) {
        for (i in 0 .. array.lastIndex) {
            // 设置锚点
            var min = i
            for (j in i+1 .. array.lastIndex) {
                // 总与后面的元素对比，如果后面元素小于当前元素，则换位置
                if (array[j] < array[min]) {
                    min = j
                }
            }
            if (i != min) {
                val temp = array[i]
                array[i] = array[min]
                array[min] = temp
            }
            show(array)
        }
    }
}
