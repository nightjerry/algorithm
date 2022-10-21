package com.jerry.algorithm.leetcode.tree

import java.util.LinkedList

/**
 *
 * @author chenjingxin
 */
object TreeAlgorithm {

    /**
     * 将有序数组转换为二叉搜索树
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xninbt/
     */


    /**
     * 二叉树的层序遍历
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnldjj/
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val queue = LinkedList<TreeNode>()
        var target = mutableListOf<MutableList<Int>>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val subTarget = mutableListOf<Int>()
            for (i in 0 until queue.size) {
                val node = queue.poll()
                subTarget.add(node.value)
                node.left?.let {
                    queue.offer(node.left)
                }
                node.right?.let {
                    queue.offer(node.right)
                }
            }
            target.add(subTarget)
        }
        return target
    }

    /**
     * 对称二叉树
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn7ihv/
     */
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root?.left, root?.right)
    }

    fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.value != right.value) {
            return false
        }
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
    }

    /**
     * 验证二叉搜索树
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn08xg/
     */
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isValidBST(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) {
            return true
        }
        //每个节点如果超过这个范围，直接返回false
        if (root.value.toLong() >= max || root.value.toLong() <= min) {
            return false
        }
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, min, root.value.toLong()) && isValidBST(root.right, root.value.toLong(), max)
    }

    /**
     * 二叉树的最大深度
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnd69e/
     */
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxOf(maxDepth(root.left), maxDepth(root.right))+1
    }

}

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
