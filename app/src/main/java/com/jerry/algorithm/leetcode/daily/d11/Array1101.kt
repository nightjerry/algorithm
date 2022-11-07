package com.jerry.algorithm.leetcode.daily.d11

import com.jerry.algorithm.show

/**
 *
 * @author chenjingxin
 */

fun main() {
    val nums = listOf(1, 2, 3, 4, 5)

    run breaking@ {
        nums.forEach {
            if (it == 3) return@breaking
            println(it)
        }
    }
    println("------")
    nums.forEach {
        if (it == 3)
            return@forEach
        println(it)
    }
}

/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum/
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        map[target - i]?.let {
            return intArrayOf(it, index)
        }
        map[i] = index
    }
    return intArrayOf(0, 0)
}

fun twoSum1(nums: IntArray, target: Int): IntArray {
    val len = nums.size
    nums.forEachIndexed { index, i ->
        ((index + 1) until len).forEach { next ->
            if (i + nums[next] == target) {
                return intArrayOf(index, next)
            }
        }
    }
    return intArrayOf(0)
}

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 *
 * - 使用归并排序，将两个数组合并一个有序数组
 * - 找出新数组的中位数
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    if (m == 0 && n == 0) {
        return 0.0
    }
    fun findMedian(target: IntArray, size: Int): Double {
        return if (size % 2 == 0) {
            (target[size / 2 - 1] + target[size / 2]) / 2.0
        } else {
            target[size / 2].toDouble()
        }
    }
    if (m == 0) {
        return findMedian(nums2, n)
    } else if (n == 0) {
        return findMedian(nums1, m)
    }
    val nums = IntArray(m + n)
    var count = 0
    var i = 0 // 代表 nums1 的指针
    var j = 0 // 代表 nums2 的指针
    while (count != (m+n)) {
        if (i == m) {
            while (j != n) {
                nums[count++] = nums2[j++]
            }
            break
        }
        if (j == n) {
            while (i != m) {
                nums[count++] = nums1[i++]
            }
            break
        }
        nums[count++] = if (nums1[i] < nums2[j]) {
            nums1[i++]
        } else {
            nums2[j++]
        }
    }
    show(nums)
    println("count = $count")
    return findMedian(nums, count)
}

/**
 * - 遍历两个数组长度的前半段
 * - 使用 left，right 记录上一次数和当前数
 *  - 如果两数组长度偶数，则 (left+right)/2
 *  - 如果两数组长度奇数，则 right
 */
fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    val count = m + n
    var left = -1
    var right = -1
    var a = 0 // 代表 nums1 的指针
    var b = 0 // 代表 nums2 的指针
    0.rangeTo(count / 2).forEach {
        left = right
        // 核心
        right = if (a < m && (b >= n || nums1[a] < nums2[b])) {
            nums1[a++]
        } else {
            nums2[b++]
        }
    }
    return if (count % 2 == 0) {
        (right + left) / 2.0
    } else {
        right.toDouble()
    }
}

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 */
fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var target = 0
    while (i < j) {
        val result = if (height[i] < height[j]) {
            (j - i) * height[i++]
        } else {
            (j - i) * height[j--]
        }
        target = maxOf(target, result)
    }
    return target
}

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
fun removeDuplicates(nums: IntArray): Int {
    var start = 0
    nums.forEach {
        if (it != nums[start]) {
            nums[++start] = it
        }
    }
    return ++start
}

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    var target = 0
    nums.forEach {
        if (it != `val`) {
            nums[target++] = it
        }
    }
    return target
}
