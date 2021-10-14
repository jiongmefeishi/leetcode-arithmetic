package me.arithmetic.dp;

// 最少找零张数，各种面额只有 1 张 dp[]
public class LT_4_MinCoinsLimitedByDpArray {

    // 空间压缩
    public int minCoins(int[] coins, int aim) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        // dp[]
        int[] dp = new int[aim + 1];

        // base case 1 dp[0] = 0
        // base case 2 i=0, 只是用 coins[0] 需要找零张数
        for (int j = 1; j <= aim; j++) {
            dp[j] = Integer.MAX_VALUE;
            if (coins[0] == aim) {
                // 只能用一张
                dp[j] = 1;
            }
        }

        // common case
        // dp[i][j]表示：在使用 coins[0...i] 面值的银币（每种面额1张）下，组合出 aim 的最少张数
        // 面额为coins[i] 的银币，可以使用，也可以不使用
        // 不使用 coins[i] 的银币，aim完全由[0...i-1] 的面额的银币组成的最小张数，  dp[i][j] = dp[i-1][j]
        // 使用 coins[i] 的银币，aim 由 j-coin[i] 和当前银币组成，如aim=20,coin=5 那么需要一张 coin ，剩下的15由其他银币组成最小数  dp[i-1][j-coins[i]] + 1
        // dp[i][j] = min{dp[i - 1][j], dp[i-1][j-coins[i]] + 1}

        // 以上是空间未压缩前写法
        // 规律 (i,j) 点状态依赖于两个点 (i-1,j) 和 (i-1, j-coins[i]) 的状态
        // 画出dp[][], 很容易得到下面的归纳
        // dp[] 其中
        // dp[j] 未更新前等同于 dp[i-1][j]
        // dp[j-coins[i]] 未更新前值等同于 dp[i-1][j-coins[i]] 因为只能使用一张


        for (int i = 1; i < coins.length; i++) {
            // 反向更新状态，无需保存 为更新前 dp[j-coins[i]] 值
            for (int j = aim; j >= 1; j--) {
                // 使用当前面额
                int num = Integer.MAX_VALUE;
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    num = dp[j - coins[i]] + 1;
                }

                int unChoose = dp[j];
                dp[j] = Math.min(unChoose, num);
            }
        }

        return dp[aim] == Integer.MAX_VALUE ? -1 : dp[aim];

    }
}
