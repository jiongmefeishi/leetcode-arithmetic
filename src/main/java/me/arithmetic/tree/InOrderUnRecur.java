package me.arithmetic.tree;

import java.util.Stack;

// 中序遍历二叉树-递归版
public class InOrderUnRecur {

    public void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();

            if (!stack.isEmpty() || head != null) {

                if (head != null) {
                    // head 不为空，依次压栈左子树
                    stack.push(head);
                    head = head.left;
                } else {
                    // head 为空，弹栈，打印，head 指向弹栈节点的右孩子,继续压栈
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
    }
}
