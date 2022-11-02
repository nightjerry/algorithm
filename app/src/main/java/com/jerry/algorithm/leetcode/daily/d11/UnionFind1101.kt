package com.jerry.algorithm.leetcode.daily.d11

/**
 *
 * @author chenjingxin
 */

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */
fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toSet()
    var longest = 0
    numSet.filterNot {
        // 过滤掉数组中前驱数 it - 1
        numSet.contains(it - 1)
    }.forEach {
        var current = it
        var streak = 1
        while (numSet.contains(current + 1)) {
            current++
            streak++
        }
        longest = maxOf(longest, streak)
    }
    return longest
}

