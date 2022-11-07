package com.jerry.algorithm.leetcode.daily.d11

/**
 *
 * @author chenjingxin
 */

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    val left = binarySearch(nums, target, true)
    val right = binarySearch(nums, target, false) -1
    if (left <= right && right < nums.size && nums[left] == target) {
        return intArrayOf(left, right)
    }
    return intArrayOf(-1, -1)
}

private fun binarySearch(nums: IntArray, target: Int, isLower: Boolean): Int {
    var left = 0
    var right = nums.lastIndex
    var result = nums.size
    while (left <= right) {
        var mid = (left + right) / 2
        if (nums[mid] > target || (isLower && nums[mid] >= target)) {
            right = mid -1
            result = mid
        } else {
            left = mid + 1
        }
    }
    return result
}
