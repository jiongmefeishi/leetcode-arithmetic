package me.arithmetic.dp;

/**
 * @author: zqtao
 * @date: 2021/8/4 15:25
 * @description: 72. 编辑距离
 */
public class LT_2_MinDistanceRecur {

    // 暴力递归
    public static int minDistance(String word1, String word2) {
        return recur(word1, word2, 0, 0);
    }

    // 表示将 w1[0...i] 编辑成 w2[0...j] 的编辑距离
    public static int recur(String w1, String w2, int i, int j) {
        // w1 先走完，返回 w2 剩余长度
        if (i == w1.length()) {
            return w2.length() - j;
        }

        // w2 先走完，返回 w1 剩余长度
        if (j == w2.length()) {
            return w1.length() - i;
        }

        // i j 位置的两个字符相同，无需编辑操作，继续下一组匹配
        if (w1.charAt(i) == w2.charAt(j)) {
            return recur(w1, w2, i + 1, j + 1);
        } else {

            // w1[i] != w2[j] 但是前面 w1[0... i-1] 已经是等于 w2[0... j-1] 的了
            // 不相同，三种选择 插入，删除，替换

            // 选择插入操作
            // w1   a b 1 2 3
            // w2   a b m 2 3
            // w1[0...i-1] 段 {a b} 想要变成 w2[0...j]  {a b m}
            // 需要将 w2[j] 插入到 w1[i] 的位置
            // 即将 m 插入到 1 原来的位置
            // w1   a b m 1 2 3
            // w2   a b m 2 3
            // 此时 i --> 1 , j --> m, 所以 j 需要后移一步，进入下轮比较 j+1 --> 2
            int insert = recur(w1, w2, i, j + 1) + 1;

            // 选择删除操作
            // w1   a b 1 2 3
            // w2   a b m 2 3
            // w1[0...i-1] 段 {a b} 想要变成 w2[0...j]  {a b m}
            // 不想要当前字符 w1[i] 那么就删除 w1[i]
            // 即删除 1
            // w1   a b   2 3
            // w2   a b m 2 3
            // 此时 i --> 空位 , j --> m, 所以 i 需要后移一步，进入下轮比较 i+1 --> 2
            int delete = recur(w1, w2, i + 1, j) + 1;

            // 选择替换操作
            // w1   a b 1 2 3
            // w2   a b m 2 3
            // w1[0...i-1] 段 {a b} 想要变成 w2[0...j]  {a b m}
            // 直接将 w1[i] 替换成 w2[j]
            // 即将 1 替换成 m
            // w1   a b m 2 3
            // w2   a b m 2 3
            // 此时 i --> m , j --> m, 此时两者相同，全都后移一步，进入下轮比较 i+1, j+1
            int replace = recur(w1, w2, i + 1, j + 1) + 1;

            // 选择距离最小的方案
            return Math.min(Math.min(insert, delete), replace);
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
