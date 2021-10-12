package me.arithmetic.tree;

import java.util.Stack;

// 先序遍历二叉树
public class PreOrderUnRecur {

    public void preOrderUnRecur(TreeNode head) {
        if (head != null) {
            // 先序遍历，根左右
            Stack<TreeNode> stack = new Stack<>();
            // 根节点入栈
            stack.add(head);

            // 栈不为空，循环不停止
            while (!stack.isEmpty()) {
                // 弹栈
                TreeNode cur = stack.pop();
                // 打印当前节点
                System.out.print(cur.val + " ");
                // 右孩子不为空，入栈
                if (cur.right != null) {
                    stack.push(cur.right);
                }

                // 左孩子不为空
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

    }
}
