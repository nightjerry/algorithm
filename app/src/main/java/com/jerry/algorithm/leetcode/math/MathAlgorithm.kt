package com.jerry.algorithm.leetcode.math

import java.util.Stack

/**
 *
 * @author chenjingxin
 */
object MathAlgorithm {


    fun missingNumber(nums: IntArray): Int {
        var target = 0
        nums.forEachIndexed { index, value ->
            target = target.xor(value.xor(index + 1))
        }
        return target
    }

    /**
     * 有效的括号
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnbcaj/
     *
     */
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            when {
                it == '(' -> {
                    stack.push(')')
                }
                it == '[' -> {
                     stack.push(']')
                }
                it == '{' -> {
                    stack.push('}')
                }
                stack.isEmpty() || stack.pop() != it -> {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }

    /**
     * 杨辉三角
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xncfnv/
     */
    fun generate(numRows: Int): List<List<Int>> {
        val target = mutableListOf<List<Int>>()
        val row = mutableListOf<Int>()
        for (i in 0 until numRows) {
            row.add(0, 1)
            for (j in 1 until row.lastIndex) {
                row[j] = row[j] + row[j+1]
            }
            target.add(row.toList())
        }
        return target
    }

    /**
     * 计数质数
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnzlu6/
     */
    fun countPrimes(n: Int): Int {
        return 0
    }

    /**
     * Fizz Buzz
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xngt85/
     */
    fun fizzBuzz(n: Int): List<String> {
        val list = arrayListOf<String>()
        for (i in 1 .. n) {
            if (i % 15 == 0) {
                list.add("FizzBuzz")
                continue
            }
            if (i % 3 == 0) {
                list.add("Fizz")
            } else if (i % 5 == 0) {
                list.add("Buzz")
            } else {
                list.add("$i")
            }
        }
        return list
    }
}
