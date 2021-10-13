package me.arithmetic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树层级遍历
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 存储层级遍历结果
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 申明队列作为层级遍历中枢
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加节点到队列末尾
        // 第一层入队
        queue.offer(root);

        // 按照层级遍历，每次入队一层所有的节点
        while (!queue.isEmpty()) {
            // 获取当前层节点个数
            int currentLevelSize = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                // 弹出队首节点
                TreeNode poll = queue.poll();
                // 记录当前节点
                levelNodes.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(levelNodes);
        }

        return res;
    }

}
