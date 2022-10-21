package com.jerry.algorithm.leetcode.sort

/**
 * 排序和搜索
 *
 * @author chenjingxin
 */
object Sort1 {

    /**
     * 第一个错误的版本
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnto1s/
     */


    /**
     * 合并两个有序数组
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnumcr/
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val temp = IntArray(m + n)
        var i = 0
        var j = 0
        var index = 0
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index++] = nums1[i++]
            } else {
                temp[index++] = nums2[j++]
            }
        }
        while (i < m) {
            temp[index++] = nums1[i++]
        }
        while (j < n) {
            temp[index++] = nums2[j++]
        }
        for (k in 0 until m+n) {
            nums1[k] = temp[k]
        }
    }
}
