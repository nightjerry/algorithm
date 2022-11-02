package com.jerry.algorithm.leetcode.daily.d11

/**
 *
 * @author chenjingxin
 */

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
fun lengthOfLongestSubstring(s: String): Int {
    var target = 0
    var right = 0
    val chars = hashSetOf<Char>()
    val size = s.length
    s.forEachIndexed { index, _ ->
        if (index > 0) {
            chars.remove(s[index - 1])
        }
        while (right < size && !chars.contains(s[right])) {
            chars.add(s[right])
            right++
        }
        target = maxOf(target, right -index)
    }
    return target
}
