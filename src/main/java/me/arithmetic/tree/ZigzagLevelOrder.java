package me.arithmetic.tree;

import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 申明队列存储每次入队的某层节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            // 存储当前层节点值
            Deque<Integer> levelNode = new LinkedList<>();

            // 当前层节点个数
            int levelNodeSize = queue.size();
            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode poll = queue.poll();

                // 存储当前节点入层
                if (isOrderLeft) {
                    levelNode.offerLast(poll.val);
                } else {
                    levelNode.offerFirst(poll.val);
                }

                // 左右子节点存在，入队
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            res.add(new LinkedList<>(levelNode));
        }
        return res;
    }
}
