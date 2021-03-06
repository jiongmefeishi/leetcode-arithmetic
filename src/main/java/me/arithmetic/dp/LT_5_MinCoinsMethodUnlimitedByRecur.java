package me.arithmetic.dp;

// 找零方法数，各种面额不限张数
public class LT_5_MinCoinsMethodUnlimitedByRecur {

    // 暴力递归
    public int minCoins(int[] coins, int aim) {
        if (aim < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        return recur(coins, 0, aim);
    }

    // 递归表示：在使用 [index...aim] 范围的面值银币组成 aim，共有多少种方法
    public int recur(int[] coins, int index, int aim) {
        int res = 0;
        if (index == coins.length) {
            res = aim == 0 ? 1 : 0;
        } else {

            // coins=[5,10,20,50] aim=100 假设当前面值是 5
            // 当前面值取 0张5时，任意使用剩下的[10,20,50]组成剩下100,共有多少种组成方法？
            // 当前面值取 1张5时，任意使用剩下的[10,20,50]组成剩下95,共有多少种组成方法？
            // 当前面值取 2张5时，任意使用剩下的[10,20,50]组成剩下90,共有多少种组成方法？
            for (int i = 0; coins[index] * i <= aim; i++) {
                res += recur(coins, index + 1, aim - coins[index] * i);
            }
        }
        return res;
    }
}
