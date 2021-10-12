package me.arithmetic.tree;

import java.util.Stack;

public class PosOrderUnRecur {

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
}
