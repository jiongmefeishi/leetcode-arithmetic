package me.arithmetic.tree;

// 先序遍历二叉树
public class PreOrderRecur {

    public void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        // 先序遍历，根左右
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}
