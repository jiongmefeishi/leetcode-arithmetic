package me.arithmetic.dp;

// 找零方法数，各种面额不限张数
public class LT_5_MinCoinsMethodUnlimitedByDpArray {

    // 动态规划 + 空间压缩
    public int minCoins(int[] coins, int aim) {

        if (coins == null || coins.length == 0 || aim < 0) {
            return 0;
        }

        // dp[]
        int[] dp = new int[aim + 1];

        // base case
        for (int j = 0; j * coins[0] <= aim; j++) {
            coins[j * coins[0]] = 1;
        }

        // common case
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
                // dp[i][j] 依赖点 (i-1, j), (i, j-coins[i])
                dp[j] += j - coins[i] >= 0 ? dp[j - coins[i]] : 0 ;
            }
        }

        return dp[aim];
    }
}
