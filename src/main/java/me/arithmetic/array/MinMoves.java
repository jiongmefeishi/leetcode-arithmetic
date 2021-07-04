package me.arithmetic.array;

import java.util.Arrays;

/**
 * @author: zqtao
 * @date: 2021/6/29 16:03
 * @description: 453. 最小操作次数使数组元素相等
 */
public class MinMoves {


    //
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }


    //排序后计算跨步，最大值到最小值跨步累加就是操作次数
    //时间复杂度：O(nlog(n))。 排序需要 O(nlog(n)) 的时间。
    //空间复杂度：O(1)。不需要额外空间。
    public static int minMoves(int[] nums) {
        // 4 1 9 3

        //  1  3  4  9      排序后
        //  9 11 12  9      跨步：8
        // 12 14 12 12      跨步：3
        // 14 14 14 14      跨步：2

        Arrays.sort(nums);
        int count = 0;
        int min = nums[0];
        int step = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            // 计算跨步 = 最大最小差值
            step = nums[i] - min;
            // 累加跨步
            count += step;
            // 更新 nums[i - 1]
            nums[i - 1] = nums[i - 1] + count;
            // 更新最小数
            min += step;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = {3,1,9,4};
//        int[] nums = {3, 1};
        int[] nums = {3};
        System.out.println(minMoves(nums));
    }
}

/*
给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。

 

示例：

输入：
[1,2,3]
输出：
3
解释：
只需要3次操作（注意每次操作会增加两个元素的值）：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/*
该方法基于以下思路：将除了一个元素之外的全部元素+1，等价于将该元素-1，因为我们只对元素的相对大小感兴趣。因此，该问题简化为需要进行的减法次数。

显然，我们只需要将所有的数都减到最小的数即可。为了找到答案，我们不需要真的操作这些元素。只需要 moves=\sum_{i=0}^{n-1} a[i] - min(a)*nmoves=∑
i=0
n−1
​
 a[i]−min(a)∗n 即可，其中 nn 为数组的数量。

作者：LeetCode
链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
