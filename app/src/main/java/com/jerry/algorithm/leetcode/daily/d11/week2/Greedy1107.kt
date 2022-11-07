package com.jerry.algorithm.leetcode.daily.d11.week2

/**
 *
 * @author chenjingxin
 */

/**
 * 605. 种花问题
 * https://leetcode.cn/problems/can-place-flowers/
 */
fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var index = 0
    val size = flowerbed.size
    var target = n
    while (index < size && target > 0) {
        // 1 当遍历到index遇到1时，说明这个位置有花，那必然从index+2的位置才有可能种花，因此当碰到1时直接跳过下一格
        index += if (flowerbed[index] == 1) {
            2
        } else if (index == size -1 || flowerbed[index +1] == 0) {
            // 2. 遍历到index遇到0时，由于每次碰到1都是跳两格，因此前一格必定是0，此时只需要判断下一格是不是1即可得出index这一格能不能种花，如果能种则令n减一,然后这个位置就按照遇到1时处理
            target--
            2
        } else {
            // 3. 如果index的后一格是1，说明这个位置不能种花且之后两格也不可能种花（参照【1】），直接跳过3格
            3
        }
    }
    // 当n减为0时，说明可以种入n朵花，则可以直接退出遍历返回true
    return target <= 0
}

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/
 */
fun canJump(nums: IntArray): Boolean {
    var most = 0
    val lastIndex = nums.lastIndex
    nums.forEachIndexed { index, i ->
        if (index <= most) {
            most = maxOf(most, index + i)
            if (most >= lastIndex) {
                return true
            }
        }
    }
    return false
}
