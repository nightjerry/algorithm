package com.jerry.algorithm.leetlink

import java.util.Stack

/**
 *
 * @author chenjingxin
 */
object LinkAlgorithm {

    @JvmStatic
    fun main(args: Array<String>) {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(6)
        val node4 = ListNode(3)
        val node5 = ListNode(4)
        val node6 = ListNode(6)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        val result = removeElements(node1, 6)
        printlnLink(result)
    }

    /**
     * 旋转链表
     * https://leetcode.cn/leetbook/read/linked-list/f00a2/
     */
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }
        var size = 1
        var target = head
        var current = target
        while (current?.next != null) {
            size++
            current = current.next
        }
        current?.next = target
        // n - k % n是新链表头节点的索引
        // n - k % n - 1是新链表尾节点的索引
        for (i in 0 until size-k % size-1) {
            target = target?.next
        }
        val result = target?.next
        target?.next =null
        return result
    }

    /**
     * 两数相加
     * https://leetcode.cn/leetbook/read/linked-list/fv6w7/
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head: ListNode?= null
        var tail: ListNode? = null
        var carry = 0
        var node1 = l1
        var node2 = l2
        while (node1 != null || node2 != null) {
            val n1 = node1?.value ?: 0
            val n2 = node2?.value ?: 0
            val sum = n1 + n2 + carry
            if (head == null) {
                head = ListNode(sum % 10)
                tail = head
            } else {
                tail?.next = ListNode(sum % 10)
                tail = tail?.next
            }
            carry = sum / 10
            node1 = node1?.next
            node2 = node2?.next
        }
        if (carry > 0) {
            tail?.next = ListNode(carry)
        }
        return head
    }

    /**
     *
     */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        var result = ListNode(0)
        var prev = result
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                prev.next = l1
                l1 = l1?.next
            } else {
                prev.next = l2
                l2 = l2.next
            }
            prev = prev.next!!
        }
        prev.next = l1 ?: l2
        return result.next
    }

    /**
     * 回文链表
     * https://leetcode.cn/leetbook/read/linked-list/fov6t/
     */
    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        // 如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow?.next
        }
        // 反转后半部分链表
        slow = reverse(slow)
        fast = head
        while (slow != null) {
            if (fast?.value != slow?.value) {
                return false
            }
            fast = fast?.next
            slow = slow?.next
        }
        return true
    }

    private fun reverse(node: ListNode?): ListNode? {
        var pre: ListNode? = null
        var target = node
        while (target != null) {
            val temp = target?.next
            target.next = pre
            pre = target
            target = temp
        }
        return pre
    }

    /**
     * 奇偶链表
     * https://leetcode.cn/leetbook/read/linked-list/fe0kj/
     */
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var evenHead = head.next
        // 奇节点
        var odd = head
        // 偶节点
        var even = evenHead
        while (even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        odd?.next = evenHead
        return head
    }

    private fun printlnLink(node: ListNode?) {
        var target = node
        while (target != null) {
            print("${target.value}、")
            target = target.next
        }
        println()
    }

    /**
     * 移除链表元素
     * https://leetcode.cn/leetbook/read/linked-list/f9izv/
     */
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }

        head.next = removeElements(head.next, `val`)

        return if (head.value == `val`) {
            head.next
        } else {
            head
        }
    }

    /**
     * 移除链表元素
     * https://leetcode.cn/leetbook/read/linked-list/f9izv/
     */
    fun removeElements1(head: ListNode?, `val`: Int): ListNode? {
        val target = ListNode(0)
        target.next = head
        var result = target
        while (result?.next != null) {
            if (result.next?.value == `val`) {
                result.next = result.next?.next
            } else {
                result = result?.next!!
            }
        }
        return target.next
    }

    /**
     * 反转链表
     * https://leetcode.cn/leetbook/read/linked-list/f58sg/
     */
    fun reverseList(head: ListNode?): ListNode? {
        var target: ListNode? = null
        var source = head
        while (source != null) {
            //先保存访问的节点的下一个节点，保存起来
            val temp = source.next
            source.next = target
            //更新新链表
            target = source
            //重新赋值，继续访问
            source = temp
        }
        return target
    }

    /**
     * 反转链表
     * https://leetcode.cn/leetbook/read/linked-list/f58sg/
     */
    fun reverseLink(node: ListNode?): ListNode? {
        val stack = Stack<ListNode>()
        var temp = node
        // 把链表节点全部摘掉放到栈中
        while (temp != null) {
            stack.push(temp)
            temp = temp?.next
        }
        if (stack.isEmpty()) {
            return null
        }
        var target = stack.pop()
        val targetHead = target
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (stack.isNotEmpty()) {
            target.next = stack.pop()
            target = target?.next
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        target.next = null
        return targetHead
    }

    /**
     * 删除链表的倒数第N个节点 - 双指针求解
     * https://leetcode.cn/leetbook/read/linked-list/jf1cc/
     */
    fun removeNthFromEnd1(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head
        // fast 移动 n 步
        for (i in 0 until n) {
            fast = fast?.next
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null) {
            return head?.next
        }
        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return head
    }

    /**
     * 删除链表的倒数第N个节点
     * https://leetcode.cn/leetbook/read/linked-list/jf1cc/
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var pre = head
        val last = linkSize(head) - n
        //如果last等于0表示删除的是头结点
        if (last == 0) {
            return head?.next
        }
        //这里首先要找到要删除链表的前一个结点
        for (i in 0 until last -1) {
            pre = pre?.next
        }
        pre?.next = pre?.next?.next
        return head
    }

    /**
     * 相交链表
     * https://leetcode.cn/leetbook/read/linked-list/jjbj2/
     */
    fun getIntersectionNode1(headA:ListNode?, headB:ListNode?):ListNode? {
        var tempA = headA
        var tempB = headB
        while (tempA != tempB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA = if (tempA == null) {
                headB
            } else {
                tempA.next
            }
            tempB = if (tempB == null) {
                headA
            } else {
                tempB.next
            }
        }
        return tempA
    }

    /**
     * 相交链表
     * https://leetcode.cn/leetbook/read/linked-list/jjbj2/
     */
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var targetA = headA
        var targetB = headB
        var sizeA = linkSize(headA)
        var sizeB = linkSize(headB)
        while (sizeA != sizeB) {
            if (sizeA > sizeB) {
                targetA = targetA?.next
                sizeA--
            } else {
                targetB = targetB?.next
                sizeB--
            }
        }
        while (targetA != targetB) {
            targetA = targetA?.next
            targetB = targetB?.next
        }
        return targetA
    }

    private fun linkSize(node: ListNode?): Int {
        var size = 0
        var target = node
        while (target != null) {
            target = target?.next
            size++
        }
        return size
    }

    /**
     * 环形链表 II - 环入口
     * https://leetcode.cn/leetbook/read/linked-list/jjhf6/
     */
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            // 有环
            if (slow == fast) {
                var target = head
                //两相遇指针，一个从头结点开始，
                //一个从相遇点开始每次走一步，直到
                //再次相遇为止
                while (target != slow) {
                    target = target?.next
                    slow = slow?.next
                }
                return target
            }
        }
        return null
    }

}

class ListNode(var value: Int) {
    var next: ListNode? = null
}
