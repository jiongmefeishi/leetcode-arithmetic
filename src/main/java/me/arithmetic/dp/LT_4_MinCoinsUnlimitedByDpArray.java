package me.arithmetic.dp;

// 最少找零张数，面额张数任意使用 dp[]
public class LT_4_MinCoinsUnlimitedByDpArray {

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
            if (j - coins[0] >= 0 && dp[j - coins[0]] != Integer.MAX_VALUE) {
                dp[j] = dp[j - coins[0]] + 1;
            }
        }

        // common case
        // dp[i][j]表示：在使用任意张 coins[0...i] 面值的银币下，组合出 aim 的最少张数
        // 面额为coins[i] 的银币，可以使用，也可以不使用
        // 不使用 coins[i] 的银币，aim完全由[0...i-1] 的面额的银币任意组成的最小张数
        // 使用 coins[i] 的银币，aim 由 j-coin[i] 和当前银币组成

        // dp[j] = min{dp[j], dp[j-coins[i]] + 1}
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
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
