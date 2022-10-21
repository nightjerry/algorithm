package com.jerry.algorithm.leetcode.search

/**
  *
  * @author chenjingxin
  */
object Search {

    /**
     * 35. 搜索插入位置
     * https://leetcode.cn/problems/search-insert-position/
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        var result = nums.size
        while (left <= right) {
            val mid = (right - left) /2 + left
            if (target <= nums[mid]) {
                result = mid
                right = mid -1
            } else {
                left = mid + 1
            }
        }
        return result
    }

    /**
     * 猜数字大小
     * https://leetcode.cn/problems/guess-number-higher-or-lower/
     */
    fun guessNumber(n:Int):Int {
        var left = 1
        var right = n
        while (left < right) {
            var mid = (right - left ) / 2 + left

            if (guess(mid) < 0) {
                right = mid -1
            } else if (guess(mid) > 0) {
                left = mid + 1
            } else {
                return mid
            }
        }
        return left
    }

    private fun guess(num: Int): Int = 0

    /**
     * 二分查找
     * https://leetcode.cn/problems/binary-search/
     */
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            var mid = (end -start)/ 2 + start
            if (nums[mid] > target){
                end = mid - 1
            } else if (nums[mid] < target) {
                start = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}
