package com.jerry.algorithm.leetcode.daily.d11

/**
 *
 * @author chenjingxin
 */

/**
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/submissions/
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    // 1. 先将 nums2 存放到 nums1 末尾
    nums2.forEachIndexed { index, _ ->
        nums1[m + index] = nums2[index]
    }
    // 2. 将 nums1 排序
    nums1.sort()
}

fun merge1(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = 0
    var p2 = 0
    val result = IntArray(m + n)
    result.forEachIndexed { index, _ ->
        result[index] = when {
            p1 == m -> {
                nums2[p2++]
            }
            p2 == n -> {
                nums1[p1++]
            }
            nums1[p1] < nums2[p2] -> {
                nums1[p1++]
            }
            else -> {
                nums2[p2++]
            }
        }
    }
    result.forEachIndexed { index, i ->
        nums1[index] = i
    }
}

/**
 * 双指针解法
 * - 新建数组，长度为 m+n
 * - 向新数组中从小到大插入元素
 * - 遍历新数组，给 nums1 赋值
 */
fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = 0
    var p2 = 0
    val result = IntArray(m + n)
    while (p1 < m || p2 < n) {
        result[p1 + p2] = when {
            p1 == m -> {
                nums2[p2++]
            }
            p2 == n -> {
                nums1[p1++]
            }
            nums1[p1] < nums2[p2] -> {
                nums1[p1++]
            }
            else -> {
                nums2[p2++]
            }
        }
    }
    result.forEachIndexed { index, i ->
        nums1[index] = i
    }
}

/**
 * 逆向双指针
 * 优点：不需要额外空间
 */
fun merge3(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    // 1.定义两个指针，分别指向两个数组的末尾
    var p1 = m - 1
    var p2 = n - 1
    // 2.获取 nums1 的末尾指针
    var tail = nums1.lastIndex
    // 3. 遍历，每次取出最大值放到数组末尾，
    while (p1 >= 0 || p2 >= 0) {
        nums1[tail--] = when {
            p1 == -1 -> {
                nums2[p2--]
            }
            p2 == -1 -> {
                nums1[p1--]
            }
            nums1[p1] > nums2[p2] -> {
                nums1[p1--]
            }
            else -> {
                nums2[p2--]
            }
        }
    }
}

private lateinit var mergeTarget: IntArray

/**
 * 归并排序
 */
private fun testMergeSort(array: IntArray) {
    mergeTarget = IntArray(array.size)
    testMergeSort(array, 0, array.lastIndex)
}

private fun testMergeSort(array: IntArray, start: Int, end: Int) {
    if (end <= start) {
        return
    }
    val mid = start + (end - start) / 2
    // 左半边排序
    testMergeSort(array, start, mid)
    testMergeSort(array, mid+1, end)
    testMerge(array, start, mid, end)
}

private fun testMerge(array: IntArray, start: Int, mid: Int, end: Int) {
    var left = start
    var right = mid + 1
    start.rangeTo(end).forEach {
        mergeTarget[it] = array[it]
    }
    start.rangeTo(end).forEach {
        array[it] = when {
            left > mid -> {
                mergeTarget[right++]
            }
            right > end -> {
                mergeTarget[left++]
            }
            mergeTarget[right] < mergeTarget[left] -> {
                mergeTarget[right++]
            }
            else -> {
                mergeTarget[left++]
            }
        }
    }
}
