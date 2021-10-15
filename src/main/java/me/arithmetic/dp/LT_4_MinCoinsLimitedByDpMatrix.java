package me.arithmetic.dp;

// 最少找零张数，各种面额只有 1 张 dp[][]
public class LT_4_MinCoinsLimitedByDpMatrix {

    public int minCoins(int[] coins, int aim) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        // dp[][] ， dp[i][j]表示：在使用任意张 arr[0...i] 面值的银币下，组合出 aim 的最少张数
        // 长度为 aim + 1 是因为需要考虑 aim=0 时候情况状态
        int[][] dp = new int[coins.length][aim + 1];

        // base case 1 j=0 找零 aim=0 情况下，张数为0
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        // base case 2 i=0 使用arr[0] 情况下，计算第一行找零需要张数，不可找零标记 无穷大
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = Integer.MAX_VALUE;
            if (j == coins[0]) {
                dp[0][j] = 1;
            }
        }

        // common case
        // dp[i][j]表示：在使用 coins[0...i] 面值的银币（每种面额1张）下，组合出 aim 的最少张数
        // 面额为coins[i] 的银币，可以使用，也可以不使用
        // 不使用 coins[i] 的银币，aim完全由[0...i-1] 的面额的银币组成的最小张数，  dp[i][j] = dp[i-1][j]
        // 使用 coins[i] 的银币，aim 由 j-coin[i] 和当前银币组成，如aim=20,coin=5 那么需要一张 coin ，剩下的15由其他银币组成最小数  dp[i-1][j-coins[i]] + 1
        // dp[i][j] = min{dp[i - 1][j], dp[i-1][j-coins[i]] + 1}
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
                int num = Integer.MAX_VALUE;
                if (j - coins[i] >= 0 && dp[i - 1][j - coins[i]] != Integer.MAX_VALUE) {
                    // 选择当前面额
                    num = dp[i - 1][j - coins[i]] + 1;
                }

                // 不选择当前面额
                int unChoose = dp[i - 1][j];

                dp[i][j] = Math.min(unChoose, num);
            }
        }

        return dp[coins.length - 1][aim] != Integer.MAX_VALUE ? dp[coins.length - 1][aim] : -1;
    }

}
