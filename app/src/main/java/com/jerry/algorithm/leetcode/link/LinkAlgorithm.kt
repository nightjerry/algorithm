package com.jerry.algorithm.leetcode.link

/**
 *
 * @author chenjingxin
 */
object LinkAlgorithm {

    @JvmStatic
    fun main(args: Array<String>) {
        testLink()

    }

    fun testLink() {
        val list1a = ListNode(1)
        val list1b = ListNode(2)
        val list1c = ListNode(4)
        val list2a = ListNode(1)
        val list2b = ListNode(3)
        val list2c = ListNode(4)
        list1a.next = list1b
        list1b.next = list1c
        list2a.next = list2b
        list2b.next = list2c
//        var result = mergeTwoLists1(list1a, list2a)
//        while (result != null) {
//            println("result = ${result.value} .")
//            result = result.next
//        }
        printListNode(list1a)
    }

    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow?.next
        }
        slow = reverse(slow)
        fast = head
        while(slow != null) {
            if (fast?.value != slow.value) {
                return false
            }
            fast = fast.next
            slow = slow.next
        }
        return true
    }

    private fun reverse(node: ListNode?): ListNode? {
        var prev:ListNode? = null
        var current = node
        while (current != null) {
            val temp = current?.next
            current?.next = prev
            prev = current
            current = temp

        }
        return prev
    }

    /**
     * 使用递归方式逆序打印链表
     */
    fun printListNode(node: ListNode?) {
        if (node == null) {
            return
        }
        printListNode(node.next)
        println(node.value)
    }

    /**
     * 合并两个有序链表
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnbp2/
     */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        var l1 = list1
        var l2 = list2
        var target = ListNode(0)
        var current = target
        while (l1 != null && l2 != null) {
            //比较一下，哪个小就把哪个放到新的链表中
            if (l1.value <= l2.value) {
                current.next = l1
                l1 = l1.next
            } else {
                current.next = l2
                l2 = l2.next
            }
            current = current.next!!
        }
        current.next = l1 ?: l2
        return target.next
    }

    /**
     * 递归
     */
    fun mergeTwoLists1(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        var l1 = list1
        var l2 = list2
        return if (l1.value < l2.value) {
            l1.next = mergeTwoLists1(l1.next, l2)
            println("l1 = ${l1.value}")
            l1
        } else {
            l2.next = mergeTwoLists1(l1, l2.next)
            println("l2 = ${l2.value}")
            l2
        }
    }

    /**
     * 反转链表
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnhm6/
      */
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var target: ListNode? = null
        while (current != null) {
            val temp = current.next
            current.next = target
            target = current
            current = temp
        }
        return target
    }

    /**
     * 删除链表的倒数第N个节点
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val lastIndex = nodeSize(head) - n
        if (lastIndex == 0) {
            return head?.next
        }
        var pre = head
        for (i in 0 until lastIndex - 1) {
            pre = pre?.next
        }
        pre?.next = pre?.next?.next
        return head
    }

    /**
     * 双指针
     * 删除链表的倒数第N个节点
     */
    fun removeNthFromEnd1(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head
        for (i in 0 until n) {
            fast = fast?.next
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null) {
            return head?.next
        }
        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }
        //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        slow?.next = slow?.next?.next
        return head
    }

    fun nodeSize1(node: ListNode?): Int {
        if (node == null) {
            return 0
        }
        return nodeSize1(node.next) + 1
    }

    fun nodeSize(node: ListNode?): Int {
        var target = node
        var size = 0
        while (target != null) {
            size++
            target = target.next
        }
        return size
    }

    /**
     * 删除链表中的节点
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnarn7/
     */
    fun deleteNode(node: ListNode?) {
        val next = node?.next
        node?.value = next?.value!!
        node?.next = next?.next
        next?.next = null
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}
