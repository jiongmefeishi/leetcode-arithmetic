package me.arithmetic.dp.day0930;


// 509. 斐波那契数
public class FibDp {

    // 动态规划
    public static int fib(int n) {

        if (n <= 0) {
            return 0;
        }

        // 第一步确定最终解是 dp[N]
        // 第二步，定义dp数组形态
        int[] dp = new int[n + 1];
        // 第三步，base case 初始化dp
        dp[0] = 0;
        dp[1] = 1;

        // 第三步循环遍历，一般情况
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}

