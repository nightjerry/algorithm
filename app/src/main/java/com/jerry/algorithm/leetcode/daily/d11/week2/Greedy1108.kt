package com.jerry.algorithm.leetcode.daily.d11.week2

/**
 *
 * @author chenjingxin
 */

fun main() {
    val nums = intArrayOf(2,3,1,1,4)
    println("jump = ${jump(nums)}")
}

/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 */
fun jump(nums: IntArray): Int {
    var end = 0
    var maxPosition = 0
    var step = 0
    (0 until nums.lastIndex).forEach {
        maxPosition = maxOf(maxPosition, it + nums[it])
        println("maxPosition = $maxPosition, end = $end.")
        if (it == end) {
            end = maxPosition
            step++
        }
    }
    return step
}
