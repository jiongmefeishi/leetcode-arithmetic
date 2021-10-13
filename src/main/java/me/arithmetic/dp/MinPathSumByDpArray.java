package me.arithmetic.dp;

// 最短路径和, 空间压缩，空间复杂度降为 O(min{M,N})
public class MinPathSumByDpArray {

    public int minPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int more = Math.max(matrix.length, matrix[0].length);
        int less = Math.min(matrix.length, matrix[0].length);

        // 选取较小长度作为dp 数组长度
        int[] dp = new int[less];
        dp[0] = matrix[0][0];

        // base case 单线路走 (0,0) 位置走到 (0,j) 或 (i,0) 位置最小路径和，具体根据more，less 确认
        for (int i = 1; i < less; i++) {
            dp[i] = matrix.length == less ? matrix[i][0] : matrix[0][i] + dp[i - 1];
        }

        for (int i = 1; i < less; i++) {
            dp[0] = dp[0] + matrix.length == less ? matrix[0][i] : matrix[i][0];
            for (int j = 1; j < more; j++) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + matrix.length == less ? matrix[j][i] : matrix[i][j];
            }
        }

        return dp[less - 1];
    }

}
