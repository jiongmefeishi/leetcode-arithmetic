package me.arithmetic.tree;

// 中序遍历二叉树-递归版
public class InOrderRecur {

    public void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        // 中序遍历，左根右
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }
}
