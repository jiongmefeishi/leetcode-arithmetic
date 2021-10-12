package me.arithmetic.tree;

// 后序遍历二叉树
public class PosOrderRecur {

    public void poOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        // 后序遍历，左右根
        poOrderRecur(head.left);
        poOrderRecur(head.right);
        System.out.print(head.val + " ");
    }
}
