package com.jerry.algorithm.leetcode.array

/**
 *
 * @author chenjingxin
 */
object Deduplication {

    /**
     * 移除元素
     * https://leetcode.cn/leetbook/read/all-about-array/x9p1iv/
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        //思路：与移动零的思路一样，在此题中val相当于0，
        //对nums中的val进行计数即可，遇到不等于val的，往前移动(i-count)个单位
        var size = nums.size
        var count = 0
        nums.forEachIndexed { index, i ->
            if (i == `val`) {
                count++
            } else {
                nums[index - count] = nums[index]
            }
        }
        return size - count
    }

    /**
     * 移除元素
     * https://leetcode.cn/leetbook/read/all-about-array/x9p1iv/
     */
    fun removeElement1(nums: IntArray, `val`: Int): Int {
        var target = 0
        nums.forEach { i ->
            if (i != `val`) {
                nums[target++] = i
            }
        }
        return target
    }

    /**
     * 两数之和
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2jrse/
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // key = nums.value value = nums.index
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (map[target - i] != null) {
                return intArrayOf(map[target - i]!!, index)
            }
            map[i] = index
        }
        return intArrayOf(0, 0)
    }

    /**
     * 移动零
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2ba4i/
     *
     * 使用双指针
     */
    fun moveZeroes(nums: IntArray) {
        if (nums.isEmpty()) {
            return
        }
        var index = 0
        //一次遍历，把非零的都往前挪
        nums.forEach {
            if (it != 0){
                nums[index++] = it
            }
        }
        //后面的都是0,
        while (index < nums.size) {
            nums[index++] = 0
        }
    }

    /**
     * 加一
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/
     */
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] != 9) {
                //如果数组当前元素不等于9，直接加1
                //然后直接返回
                digits[i]++
                return digits
            } else {
                //如果数组当前元素等于9，那么加1之后
                //肯定会变为0，我们先让他变为0
                digits[i] = 0
            }
        }
        //除非数组中的元素都是9，否则不会走到这一步，
        //如果数组的元素都是9，我们只需要把数组的长度
        //增加1，并且把数组的第一个元素置为1即可
        return IntArray(digits.size+1).apply {
            this[0] = 1
        }
    }

    /**
     * 两个数组的交集 II
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
     */
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        var i = 0
        var j = 0
        val list = mutableListOf<Int>()
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] < nums2[j]) {
                i++
            } else if (nums1[i] > nums2[j]) {
                j++
            } else {
                list.add(nums1[i])
                i++
                j++
            }
        }
        return list.toIntArray()
    }

    /**
     * 只出现一次的数字
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x21ib6/
     *
     * - 使用异或运算
     *  a^a=0；自己和自己异或等于0
     *  a^0=a；任何数字和0异或还等于他自己
     *  a^b^c=a^c^b；异或运算具有交换律
     */
    fun singleNumber(nums: IntArray): Int {
        var target = 0
        nums.forEach {
            target = target xor it
        }
        return target
    }

    /**
     * 存在重复元素
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x248f5/
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i -1]) {
                return true
            }
        }
        return false
    }

    /**
     * 旋转数组
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
     *
     */
    fun rotate(nums: IntArray, k: Int) {
        val kk = k % nums.size
        //先反转全部的元素
        reverse(nums, 0, nums.size - 1)
        //在反转前k个元素
        reverse(nums, 0, kk - 1)
        //接着反转剩余的
        reverse(nums, kk, nums.size - 1)
    }

    private fun reverse(nums: IntArray, s: Int, e: Int) {
        var temp: Int
        var start = s
        var end = e
        while(start < end) {
            temp = nums[start]
            nums[start++] = nums[end]
            nums[end--] = temp
        }
    }

    /**
     * 买卖股票的最佳时机 II
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }
        var target = 0
        prices.forEachIndexed { index, v ->
            if (index > 0 && v > prices[index - 1]) {
                target += v - prices[index - 1]
            }
        }
        return target
    }

    /**
     * 删除排序数组中的重复项
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
     */
    fun removeDuplicates(nums: IntArray): Int {
        var start = 0
        nums.forEach {
            if (nums[start] != it) {
                nums[++start] = it
            }
        }
        return ++start
    }
}
