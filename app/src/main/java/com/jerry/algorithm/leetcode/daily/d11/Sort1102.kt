package com.jerry.algorithm.leetcode.daily.d11

import android.annotation.SuppressLint
import kotlin.math.abs

/**
 *
 * @author chenjingxin
 */

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val size = nums.size
    // 特判，长度小于 3 返回 []
    if (size < 3) {
        return emptyList()
    }
    // * 数组排序
    nums.sort()
    val result = mutableListOf<List<Int>>()
    // 遍历，使用三个指针，分别是 index，left，right
    nums.forEachIndexed { index, i ->
        // 若 i>0 ：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
        if (i > 0) {
            return result
        }
        if (index > 0 && i == nums[index -1]) {
            return@forEachIndexed
        }
        // 双指针, 每次外圈遍历，都将 left 指向index 下一位，right 等于数组末尾
        var left = index + 1
        var right = size - 1
        while (left < right) {
            val tmp = i + nums[left] + nums[right]
            // 和大于 0，说明 nums[right] 太大，right 左移
            if (tmp > 0) {
                right -= 1
            } else if (tmp < 0) {
                // 和小于 0，说明 nums[left] 太小，left 右移
                left += 1
            } else {
                // 和等于 0，
                result.add(listOf(i, nums[left], nums[right]))
                // 执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 left,right 移到下一位置，寻找新的解
                while (left < right && nums[left] == nums[left + 1]) {
                    left += 1
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right -= 1
                }
                left += 1
                right -= 1
            }
        }
    }
    return result
}

/**
 * 16. 最接近的三数之和
 * https://leetcode.cn/problems/3sum-closest/
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    val size = nums.size
    var result = nums[0]+ nums[1]+nums[2]
    nums.forEachIndexed { index, num ->
        var start = index + 1
        var end = size - 1
        while (start < end) {
            val sum = num + nums[start] + nums[end]
//            if (sum == target) {
//                return target
//            }
            if (abs(target - sum) < abs(target - result)) {
                result = sum
            }
            if (sum > target) {
                end--
            } else if (sum < target) {
                start++
            } else {
                return result
            }
        }
    }
    return result
}

/**
 * 18. 四数之和
 * https://leetcode.cn/problems/4sum/
 */
fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val size = nums.size
    if (size < 4) {
        return emptyList()
    }
    nums.sort()
    0.rangeTo(size - 3).forEachIndexed { index, num ->
        if (index > 0 && num == nums[index - 1]) {
            return@forEachIndexed

        }
        if (num.toLong()+nums[index + 1] + nums[index + 2] + nums[index + 3]> target) {

        }
        if (num.toLong() + nums[size - 3] + nums[size - 2] + nums[size - 1] < target) {
            return@forEachIndexed
        }
        (index + 1).rangeTo(size - 2).forEachIndexed innerLoop@{ indexInner, numInner ->
            if (indexInner > index + 1 && nums[indexInner] == nums[indexInner - 1]) {
                return@innerLoop
            }
            // TODO
        }
    }
    return emptyList()
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    groupAnagrams(strs)
}

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/
 */
@SuppressLint("NewApi")
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    strs.forEach {
        val charArray = it.toCharArray()
        charArray.sort()
        val key = String(charArray)
        val list = map.getOrDefault(key, mutableListOf())
        list.add(it)
        map[key] = list
    }
    return map.values.toList()
}

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val target = mutableListOf<IntArray>()
    // 将列表中的区间按照左端点升序排序
    intervals.sortBy { it[0] }
    intervals.forEach {
        if (target.isEmpty() || target.last()[1] < it[0]) {
            // 不存在合并区间，直接添加
            target.add(it)
        } else {
            //存在合并区间，则列表最后一个数组替换为合并后的值
            target[target.lastIndex][1] = maxOf(target.last()[1], it[1])
        }
    }
    return target.toTypedArray()
}

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 */
fun sortColors(nums: IntArray): Unit {
    var start = 0
    var end = nums.lastIndex
    0.rangeTo(end).forEach { index ->
        while (index <= end && nums[index] == 2) {
            val temp = nums[index]
            nums[index] = nums[end]
            nums[end] = temp
            end--
        }
        if (nums[index] == 0) {
            val temp = nums[index]
            nums[index] = nums[start]
            nums[start] = temp
            start++
        }
    }
}

