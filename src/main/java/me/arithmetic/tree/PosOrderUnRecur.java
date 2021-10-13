package me.arithmetic.tree;

import java.util.Stack;

// 后序遍历二叉树
public class PosOrderUnRecur {

    // 双栈实现后序遍历二叉树
    public void posOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();

            s1.add(head);
            while (!s1.isEmpty()) {
                TreeNode cur = s1.pop();
                s2.push(cur);
                if (cur.left != null) {
                    s2.push(cur.left);
                }
                if (cur.right != null) {
                    s2.push(cur.right);
                }
            }

            while (!s2.isEmpty()) {
                TreeNode pop = s2.pop();
                System.out.print(pop.val + " ");
            }
        }

    }

    // 单栈后序遍历二叉树
    public void posOrderUnRecur2(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            // h 表示最近一次弹出，并打印的节点
            TreeNode h = head;
            // c 表示stack 栈顶，初始为null
            TreeNode c = null;

            // 入栈
            stack.push(h);
            while (!stack.isEmpty()) {
                // 获取栈顶元素，不弹出
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    // 条件一：c 的左孩子不为空，并且未打印过，则入栈
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    // 条件二：c 的右孩子不为空，并且未打印过，则入栈
                    stack.push(c.right);
                } else {
                    // 条件一，条件二不成立，说明 c 的左右孩子已经打印完毕，可以打印 c 了
                    // 弹出
                    stack.pop();
                    System.out.print(c.val + " ");
                    h = c;
                }
            }

        }

    }
}
