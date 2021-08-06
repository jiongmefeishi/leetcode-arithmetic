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
        // dp[0][i]：表示 w1[0...i] 编辑成 w2 空串的代价
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }

        // base case 3
        // dp[0][j]：表示 w1 空串编辑成 w2[0...j] 的代价
        for (int j = 0; j < word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                // dp[i][j] 表示 w1[0...i-1] 编辑成 w2[0...j-1] 的最小代价
                // dp[i][j] 可选有 4 种决策
                // 1、插入字符
                // 2、删除字符
                // 3、替换字符
                // 4、无需操作

                // 决策1：插入字符
                // dp[i][j-1] 表示 w1[0...j-2]

                // 决策2：删除字符
                // dp[i-1][j] 表示 w1[0...i-2] 编辑成 w2[0...j-1] 的代价
                // dp[i][j] 可能的一个决策就是 dp[i][j] = dp[i-1][j] + 1

            }
        }


    }

    public static void main(String[] args) {

//        String str1 = "zh1an2g";
//        String str2 = "zhang";
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(minDistance(str1, str2));
    }
}

