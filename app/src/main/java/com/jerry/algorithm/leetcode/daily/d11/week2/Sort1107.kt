package com.jerry.algorithm.leetcode.daily.d11.week2

import com.jerry.algorithm.show
import com.jerry.algorithm.showArray

/**
 *
 * @author chenjingxin
 */

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/
 * 题解1：计数法
 */
fun majorityElement(nums: IntArray): Int {
    var target: Map.Entry<Int, Int>? = null
    count(nums).forEach {
        if (target == null || it.value > target!!.value) {
            target = it
        }
    }
    return target!!.key
}

private fun count(nums: IntArray): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    nums.forEach {
        map[it] = if (map.containsKey(it)) {
           map[it]!! + 1
        } else {
            1
        }
    }
    return map
}

fun main() {
    val nums = intArrayOf(3,30,34,5,9)
    println("target = ${largestNumber(nums)}")
}

/**
 * 179. 最大数
 * https://leetcode.cn/problems/largest-number/
 * - 贪心算法
 */
fun largestNumber(nums: IntArray): String {
    // 首先创建字符串数组，
    val array = Array(nums.size) { nums[it].toString() }
    /**
     * 字符串比较：a.compareTo(b) 比较的时候是按照ASCII码逐位比较的，如果大于0，返回值为正数，就会交换a和b
     * - 如果a的第一个字符和b的第一个字符不等，结束比较，返回他们之间的长度差值；
     * - 如果a的第一个字符和b的第一个字符相等，则a的第二个字符和b的第二个字符做比较；
     */
//    array.sortWith { s1, s2 ->
//        return@sortWith (s2 + s1).compareTo(s1 + s2)
//    }
    array.sortWith { p0, p1 -> (p1 + p0).compareTo(p0 + p1) }
    // 如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
    return if (array[0] == "0") {
        "0"
    } else {
        array.joinToString(separator = "")
    }
}
