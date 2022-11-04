package com.jerry.algorithm.leetcode.daily.d11

import java.util.LinkedList

/**
 *
 * @author chenjingxin
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 中序遍历：左子树、根节点、右子树
 */
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    inorder(root, result)
    return result
}

private fun inorder(root: TreeNode?, result: MutableList<Int>) {
    root ?: return
    inorder(root.left, result)
    result.add(root.`val`)
    inorder(root.right, result)
}

fun inorderTraversal1(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = LinkedList<TreeNode>()
    var rootTemp = root
    while (rootTemp != null || stack.isNotEmpty()) {
        while (rootTemp != null) {
            stack.push(rootTemp)
            rootTemp = rootTemp.left
        }
        rootTemp = stack.pop()
        result.add(root!!.`val`)
        rootTemp = rootTemp.right
    }
    return result
}

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

private fun isValidBST(node: TreeNode?, lower: Long, upper: Long): Boolean {
    node ?: return true
    if (node.`val` <= lower || node.`val` >= upper) {
        return false
    }
    return isValidBST(node.left, lower, node.`val`.toLong()) && isValidBST(node.right, node.`val`.toLong(), upper)
}

/**
 * 99. 恢复二叉搜索树
 * https://leetcode.cn/problems/recover-binary-search-tree/
 */
fun recoverTree(root: TreeNode?): Unit {
    
}
