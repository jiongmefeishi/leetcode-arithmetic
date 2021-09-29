package me.arithmetic.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zqtao
 * @date: 2021/8/4 15:25
 * @description: 72. 编辑距离
 */
public class MinDistance22 {

    // 暴力递归 + 备忘录
    public static int minDistance(String word1, String word2) {
        Map<String, Integer> memory = new HashMap<>();
        return recur(word1, word2, word1.length() - 1, word2.length() - 1, memory);
    }

    // 表示将 w1[0...i] 编辑成 w2[0...j] 的编辑距离
    public static int recur(String w1, String w2, int i, int j, Map<String, Integer> memory) {

        // 先检查备忘录是否已经记录计算过的子问题
        // 存在直接返回
        if (memory.containsKey(i + "-" + j)) {
            return memory.get(i + "-" + j);
        }

        // w1 先走完，返回 w2 剩余长度
        if (i == -1) {
            return j + 1;
        }

        // w2 先走完，返回 w1 剩余长度
        if (j == -1) {
            return i + 1;
        }

        // i j 位置的两个字符相同，无需编辑操作，继续下一组匹配
        if (w1.charAt(i) == w2.charAt(j)) {
            return recur(w1, w2, i - 1, j - 1, memory);
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
            int insert = recur(w1, w2, i, j - 1, memory) + 1;

            // 选择删除操作
            // w1   a b 1 2 3
            // w2   a b m 2 3
            // w1[0...i-1] 段 {a b} 想要变成 w2[0...j]  {a b m}
            // 不想要当前字符 w1[i] 那么就删除 w1[i]
            // 即删除 1
            // w1   a b   2 3
            // w2   a b m 2 3
            // 此时 i --> 空位 , j --> m, 所以 i 需要后移一步，进入下轮比较 i+1 --> 2
            int delete = recur(w1, w2, i - 1, j, memory) + 1;

            // 选择替换操作
            // w1   a b 1 2 3
            // w2   a b m 2 3
            // w1[0...i-1] 段 {a b} 想要变成 w2[0...j]  {a b m}
            // 直接将 w1[i] 替换成 w2[j]
            // 即将 1 替换成 m
            // w1   a b m 2 3
            // w2   a b m 2 3
            // 此时 i --> m , j --> m, 此时两者相同，全都后移一步，进入下轮比较 i+1, j+1
            int replace = recur(w1, w2, i - 1, j - 1, memory) + 1;

            // 选择距离最小的方案
            int min = Math.min(Math.min(insert, delete), replace);

            // 存储进备忘录，避免下次重复计算
            memory.put(i + "-" + j, min);
            return min;
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

