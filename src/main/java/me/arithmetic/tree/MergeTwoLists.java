package me.arithmetic.tree;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 合并两个有序链表
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 判断是否存在链表为空情况
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            // 选中较小节点
            // 递归选择下一个节点 在节点 tmp=l1.next 和 l2 之间选择一个较小值作为 当前节点的下一个节点
            l1.next = mergeTwoLists(l1.next, l2);

            // 返回当前较小节点
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
