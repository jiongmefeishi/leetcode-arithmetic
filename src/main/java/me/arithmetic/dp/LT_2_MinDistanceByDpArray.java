package me.arithmetic.dp;


/**
 * @author: zqtao
 * @date: 2021/8/4 15:25
 * @description: 72. 编辑距离
 */
public class LT_2_MinDistanceByDpArray {

    // 动态规划压缩空间
    public static int minDistance(String word1, String word2) {

        // 如果某个字符串为空，编辑成另一个字符串的距离就是字符串长度
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        String moreLong = word1.length() > word2.length() ? word1 : word2;
        String lessLong = word1.length() > word2.length() ? word2 : word1;

        // 降维，利用一维数组存储转移状态
        int[] dp = new int[lessLong.length() + 1];

        // base case 1
        // w1 空串编辑成 w2 空串的代价为 0
        for (int i = 0; i <= lessLong.length(); i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= moreLong.length(); i++) {

            // 左上角状态
            int pre = dp[0];
            // moreLong 删除为lessLong 的编辑代价
            dp[0] = i;
            for (int j = 1; j <= lessLong.length(); j++) {
                // dp[i][j] 的值依赖于 dp[i-1][j] dp[i][j-1] dp[i-1][j-1] 三个状态
                // dp[j] 没更新之前相当于 dp[i-1][j]
                // dp[j-1] 值已经更新过，相当于 dp[i][j-1]
                // 这里缺少了 dp[i-1][j-1]
                // 而没有更新前的 dp[j-1] 就相当于 dp[i-1][j-1]
                // 需要一个变量 pre 来保存 没更新之前的 dp[j-1] 状态
                // 还需要一个变量 tmp 来保存 没更新之前的 dp[j] 状态，供下一个状态使用
                int tmp = dp[j];
                // 选择替换操作
                int replace = 0;
                if (moreLong.charAt(i - 1) == lessLong.charAt(j - 1)) {
                    // 字符相同，无需操作
                    replace = pre;
                } else {
                    // 不相同，选择替换操作
                    replace = pre + 1;
                }

                // 选择插入操作
                int insert = dp[j-1] + 1;

                // 选择删除操作
                int delete = dp[j] + 1;

                // 选择最小编辑代价
                dp[j] = Math.min(Math.min(insert, delete), replace);

                // 更新左上角状态
                pre = tmp;
            }
        }

        return dp[lessLong.length()];
    }


    public static void main(String[] args) {

//        String str1 = "zh1an2g";
//        String str2 = "zhang";
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(minDistance(str1, str2));
    }
}

