package com.jerry.algorithm.leetcode.dynamic

/**
 * 动态规划
 *
 * @author chenjingxin
 */
object DynamicAlgorithm {

    @JvmStatic
    fun main(args: Array<String>) {
        val result = climbStairs(43)
        println("result = $result .")
    }

    /**
     *  斐波那契数
     *  https://leetcode.cn/problems/fibonacci-number/
     */
    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }
        return fib(n - 1)+ fib(n -2)
    }

    /**
     * 最大子序和
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn3cg3/
     */
    fun maxSubArray(nums: IntArray): Int {
        var cur = nums[0]
        var max = cur
        for (i in 1 until nums.size) {
            cur = maxOf(cur, 0) + nums[i]
            max = maxOf(max, cur)
        }
        return max
    }

    /**
     * 买卖股票的最佳时机
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn8fsh/
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        var maxPrice = 0
        var min = prices[0]
        for (i in 1..prices.lastIndex) {
            min = minOf(min, prices[i])
            maxPrice = maxOf(prices[i] - min, maxPrice)
        }
        return maxPrice
    }

    /**
     * 爬楼梯
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn854d/
     */
    fun climbStairs1(n: Int): Int {
        return fibonacci(n, 1, 1)
    }

    private fun fibonacci(n: Int, a: Int, b: Int): Int {
        if (n <= 1) {
            return b
        }
        return fibonacci(n - 1, b, a+b)
    }

    fun climbStairs(n: Int): Int {
        if (n <= 1) {
            return 1
        }
        if (n < 3) {
            return n
        }
        return climbStairs(n - 1) + climbStairs(n - 2)
    }
}
