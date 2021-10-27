package me.arithmetic.dp;

import java.util.Arrays;

// 最长递增子序列 O(n*n)
public class LT_6_MaxLongestIncreasingSubsequencesByDpMatrixSimple {

    public static int[] maxLongestIncreasingSubsequences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getDp(arr);
        return generatorLIS(arr, dp);

        // 时间复杂度为 O(n*n)
        // 得到dp[] 时间复杂度为 O(n*n)
        // 根据dp[]得到最大子序列长度时间复杂度为 O(n)
    }

    // 本方法获取以 arr[i] 为结尾的情况下，arr[0...i]中最大递增子序列长度
    public static int[] getDp(int[] arr) {

        // dp[i] 表示以 arr[i] 为结尾的情况下，arr[0...i]中最大递增子序列长度
        int[] dp = new int[arr.length];
        // ends[0...right] 为有效区
        // ends[right...N-1] 为无效区
        // 对于有效区位置 b
        // 如果有 ends[b] == c
        // 表示遍历到当前位置为止，在所有长度为 b+1 的递增序列中，最小的结尾数是 c
        int[] ends = new int[arr.length];

        // base case
        // dp[0] = 1;

        // common case
        // dp[i] = max{dp[j]+1},其中 dp[j]<dp[i] && j < i

        int L = 0;
        int M = 0;
        int R = 0;
        // 标志ends 的有效区
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            L = 0;
            R = right;
            while (L < R) {
                M = (L + R) / 2;
                if (arr[i] > ends[M]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }

            right = Math.max(right, L);
            ends[L] = arr[i];
            dp[i] = L + 1;
        }

        return dp;
    }

    // 逆序dp决策过程，找到最长递增子序列
    // arr[] 2 1 5 3 6 4 8 9 7
    // dp[]  1 1 2 2 3 3 4 5 4
    public static int[] generatorLIS(int[] arr, int[] dp) {

        // 子序列长度
        int length = 0;
        int index = 0;

        // 找到最长子序列长度和下标
        for (int i = 0; i < dp.length; i++) {
            if (length < dp[i]) {
                length = dp[i];
                index = i;
            }
        }

        // 逆序决策过程
        int[] res = new int[length];
        // 结尾元素进入
        res[--length] = arr[index];

        // 其他元素
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                res[--length] = arr[i];
                index = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};

        int[] ints = maxLongestIncreasingSubsequences(arr);
        System.out.println(Arrays.toString(ints));
        // [1, 3, 4, 8, 9]

    }

}
