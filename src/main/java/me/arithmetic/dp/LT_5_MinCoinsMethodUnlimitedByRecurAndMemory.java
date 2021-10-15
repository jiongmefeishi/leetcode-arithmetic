package me.arithmetic.dp;

// 找零方法数，各种面额不限张数
public class LT_5_MinCoinsMethodUnlimitedByRecurAndMemory {

    // 暴力递归+备忘录
    public int minCoins(int[] coins, int aim) {
        if (aim < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        // memory[i][j] 表示递归过程中 recur(index, aim) 返回值
        // 其中 memory[i][j]=0 表示 recur(i, j) 未计算过
        // 其中 memory[i][j]=-1 表示 recur(i, j) 计算过
        int[][] memory = new int[coins.length][aim + 1];
        return recur(coins, 0, aim, memory);
    }

    // 递归表示：在使用 [index...aim] 范围的面值银币组成 aim，共有多少种方法
    public int recur(int[] coins, int index, int aim, int[][] memory) {

        int res = 0;
        if (index == coins.length) {
            res = aim == 0 ? 1 : 0;
        } else {

            // coins=[5,10,20,50] aim=100 假设当前面值是 5
            // 当前面值取 0张5时，任意使用剩下的[10,20,50]组成剩下100,共有多少种组成方法？
            // 当前面值取 1张5时，任意使用剩下的[10,20,50]组成剩下95,共有多少种组成方法？
            // 当前面值取 2张5时，任意使用剩下的[10,20,50]组成剩下90,共有多少种组成方法？
            for (int i = 0; coins[index] * i <= aim; i++) {
                int memoryVal = memory[index + 1][aim - coins[index] * i];
                // 计算过，直接返回
                if (memoryVal != 0) {
                    res = memoryVal == -1 ? 0 : memoryVal;
                } else {
                    res += recur(coins, index + 1, aim - coins[index], memory);
                }
            }
        }

        // 保存当前面额使用总数
        memory[index][aim] = res == 0 ? -1 : res;

        return res;
    }
}
