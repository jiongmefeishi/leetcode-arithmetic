package me.arithmetic.dp;

// 找零方法数，各种面额不限张数
public class LT_5_MinCoinsMethodUnlimitedByDpMatrixSimple {

    // 动态规划 + 时间压缩
    // LT_5_MinCoinsMethodUnlimitedByDpMatrix 中
    // 动态规划 dp[][] 的common case
    // dp[i][j] += dp[i-1][j-coins[i] * k] 其中 k >= 0，j-coins[i] * k >= 0
    // (i,j) 点状态更新依赖于点 (i-1, j) , (i-1, j-coins[i] * 1),,,,,(i-1, j-coins[i] * k) 等多个点

    // 换个思路无非就是当前这个面额的银币 coins[i] 到底使用不使用
    // 不使用，j 完全由(0...i-1) 面额组成，方法数：dp[i-1][j]
    // 使用，那么 aim= 当前面额 + (aim-当前面额)

    // 再看当初定义dp[][] 的目的是什么？
    // dp[][]， dp[i][j] 表示使用任意[0...i] 面额张数，组合成 j 所有可能组合总数
    // 那么 dp[i][j-coins[i]] 表示的就是任意使用 [0...i] 面额张数，组合成 j-coins[i] 需要组合数

    // common base
    // dp[i][j]=dp[i-1][j] + dp[i][j-coins[i]]
    public int minCoins(int[] coins, int aim) {

        if (aim < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        // dp[][]， dp[i][j] 表示使用任意[0...i] 面额张数，组合成 j 所有可能组合总数
        int[][] dp = new int[coins.length][aim + 1];

        // base case 1 j=0，组合成 0 种数
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        // base case 2 i=0, 只是用coins[0], 可以组合成 aim 种数
        for (int j = 1; j <= aim; j++) {
            dp[0][j * coins[j]] = 1;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j] + j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0;
            }
        }

        return dp[coins.length - 1][aim];

    }
}
