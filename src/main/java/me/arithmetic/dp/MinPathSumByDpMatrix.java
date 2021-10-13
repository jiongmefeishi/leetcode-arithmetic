package me.arithmetic.dp;

// 最短路径和
public class MinPathSumByDpMatrix {

    // dp[][]
    public int minPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        // dp，dp[i][j] 表示：从 (0,0) 位置走到(i,j) 位置最小路径和
        int[][] dp = new int[M][N];

        // base case 1：i=0,j=0 从(0,0) 位置走到(0,0) 位置最小路径和
        dp[0][0] = matrix[0][0];

        // base case 1：i=0, 从(0,0) 位置走到(0,j) 位置最小路径和
        for (int j = 2; j < N; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // base case 3：j=0, 从(0,0) 位置走到(i,0) 位置最小路径和
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // common base
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        return dp[M - 1][N - 1];
    }

}
