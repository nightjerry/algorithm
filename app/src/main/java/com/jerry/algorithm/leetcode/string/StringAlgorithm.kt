package com.jerry.algorithm.leetcode.string

import android.os.Build
import androidx.annotation.RequiresApi
import com.jerry.algorithm.swap

/**
 *
 * @author chenjingxin
 */
object StringAlgorithm {

    @JvmStatic
    fun main(args: Array<String>) {
        reverse(-1234)
    }

    /**
     * 验证回文串
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xne8id/
     */
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            // 只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s[left])) {
                left++
            }
            while (left < right && !Character.isLetterOrDigit(s[right])) {
                right--
            }
            if (Character.toLowerCase(s[left]) != Character.toLowerCase(s[right])) {
                return false
            }
            left++
            right--
        }
        return true
    }

    /**
     * 有效的字母异位词
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn96us/
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val array = IntArray(26)
        s.forEach {
            array[it - 'a']++
        }
        t.forEach {
            array[it - 'a']--
        }
        array.forEach {
            if (it != 0) {
                return false
            }
        }
        return true
    }

    /**
     * 字符串中的第一个唯一字符
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn5z8r/
     */
    fun firstUniqChar(s: String): Int {
        s.forEachIndexed { index, c ->
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return index
            }
        }
        return -1
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun firstUniqChar1(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        s.forEachIndexed { index, c ->
            if (map[c] == 1) {
                return index
            }
        }
        return -1
    }

    /**
     * 整数反转
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/
     */
    fun reverse(x: Int): Int {
        var xx = x
        var res = 0
        while (xx != 0) {
            val t = xx % 10
            val newRes = res * 10 + t
            if ((newRes - t) / 10 != res) {
                return 0
            }
            res = newRes
            xx /= 10
//            println("xx = $xx, res = $res.")
        }
        return res
    }

    /**
     * 反转字符串
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
     */
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            swap(s, left++, right--)
        }
    }

}
