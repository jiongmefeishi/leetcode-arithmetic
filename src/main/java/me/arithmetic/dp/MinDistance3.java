package me.arithmetic.dp;


/**
 * @author: zqtao
 * @date: 2021/8/4 15:25
 * @description: 72. 编辑距离
 */
public class MinDistance3 {

    // 动态规划
    public static int minDistance(String word1, String word2) {

        // 如果某个字符串为空，编辑成另一个字符串的距离就是字符串长度
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // base case 1
        // dp[0][0]：表示 w1 空串编辑成 w2 空串的代价为 0
        dp[0][0] = 0;

        // base case 2
        // dp[i][0]：表示 w1[0...i] 编辑成 w2 空串的代价
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        // base case 3
        // dp[0][j]：表示 w1 空串编辑成 w2[0...j] 的代价
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // dp[i][j] 表示 w1[0...i] 编辑成 w2[0...j] 的最小代价
                // dp[i][j] 可选有 4 种决策

                // 决策1：插入字符
                // w1[0...i] 先编辑成 w2[0...j-1]
                // 然后插入字符 w2[j]，w1[0...i-1] 就编辑成了 w2[0...j]
                // 那么dp[i][j-1]表示的就是 w1[0...i] 编辑成 w2[0...j-1] 的最小距离
                // 所以决策是插入时 dp[i][j] = dp[i-1][j] + 插入操作距离 1
                int insert = dp[i][j - 1] + 1;

                // 决策2：删除字符
                // w1[0...i] 先删除字符 w1[i]，编辑成 w1[0...i-1]
                // w1[0...i-1] 再编辑成 w2[0...j]
                // 那么dp[i-1][j]表示的就是 w1[0...i-1] 编辑成 w2[0...j] 的最小距离
                // 所以决策是删除时 dp[i][j] = dp[i-1][j] + 删除操作距离 1
                int delete = dp[i - 1][j] + 1;

                // 决策3：不做任何操作
                // 如果 w1[i] = w2[j]
                // 先将 w1[0...i-1] 部分编辑成 w2[0...j-1]，即相同的
                // 那么 w1[0...i] 和 w2[0...j] 也是相同的，无需任何操作
                // 那么dp[i-1][j-1]表示的就是 w1[0...i-1] 编辑成 w2[0...j-1] 的最小距离
                // 所以决策是无操作时 dp[i][j] = dp[i-1][j-1]
                int none = dp[i - 1][j - 1];

                // 决策4：替换操作
                // 如果 w1[i] != w2[j]
                // 先将 w1[0...i-1] 部分编辑成 w2[0...j-1]，即相同的
                // 再将 w1[i] 替换成 w2[j]
                // 那么 w1[0...i] 和 w2[0...j] 也是相同的
                // 那么dp[i-1][j-1]表示的就是 w1[0...i-1] 编辑成 w2[0...j-1] 的最小距离
                // 所以决策是替换时 dp[i][j] = dp[i-1][j-1] + 替换操作距离 1
                int replace = dp[i - 1][j - 1] + 1;

                // 选择距离最短方案
                dp[i][j] = Math.min(insert, delete);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // 相同时选择无操作
                    dp[i][j] = Math.min(dp[i][j], none);
                } else {
                    // 不同时选择替换操作
                    dp[i][j] = Math.min(dp[i][j], replace);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

//        String str1 = "zh1an2g";
//        String str2 = "zhang";
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(minDistance(str1, str2));
    }
}

