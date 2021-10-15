package me.arithmetic.dp;

// 找零方法数，各种面额不限张数
public class LT_5_MinCoinsMethodUnlimitedByDpMatrix {

    // 动态规划
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

        // common case

        // 暴力递归可能组合
        // coins=[5,10,20,50] aim=100 假设当前面值是 5
        // 当前面值取 0张5时，任意使用剩下的[10,20,50]组成剩下100,共有多少种组成方法？
        // 当前面值取 1张5时，任意使用剩下的[10,20,50]组成剩下95,共有多少种组成方法？
        // 当前面值取 2张5时，任意使用剩下的[10,20,50]组成剩下90,共有多少种组成方法？


        // 动态规划类比
        // 除了第一行，第一列外，其他状态点 dp[i][j]状态是以下状态值累加
        // 1、不使用 coins[i] 面额的银币时， 组成 j ,使用的是 [0...i-1] 面额的银币，方法数为dp[i-1][j]
        // 2、使用1张 coins[i]，剩下钱j-coins[i] * 1使用 [0...i-1] 面额银币组成，方法数为dp[i-1][j-coins[i]]
        // 3、使用2张 coins[i]，剩下钱j-coins[i] * 2使用 [0...i-1] 面额银币组成，方法数为dp[i-1][j-coins[i] * 2]
        // 4、使用k张 coins[i]，剩下钱j-coins[i] * k使用 [0...i-1] 面额银币组成，方法数为dp[i-1][j-coins[i] * k]
        // dp[i][j] += dp[i-1][j-coins[i] * k] 其中 k >= 0，j-coins[i] * k >= 0
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
                int count = 0;
                for (int k = 0; j >= coins[i] * k; k++) {
                    count += dp[i - 1][j - coins[i] * k];
                }
                dp[i][j] = count;
            }
        }

        return dp[coins.length - 1][aim];

    }
}
