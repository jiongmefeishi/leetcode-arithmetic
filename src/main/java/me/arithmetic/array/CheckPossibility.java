package me.arithmetic.array;

/**
 * @author: zqtao
 * @date: 2021/7/2 17:25
 * @description: 665. 非递减数列
 */
public class CheckPossibility {

    // nums[i] <= nums[i + 1]
    public boolean checkPossibility(int[] nums) {

        // 4 2 3 4
        // 从后往前遍历，以a[i] 为开始  a[i]~a[N-1] 范围内的数都是递增序列
        // a[i] < L ? L--
        // a[i] >= L ? 更新 a[i] = a[L]-1, L--

        // 从前往后遍历，以a[i] 为结束  a[0]~a[i]   范围内的数都是递增序列
        // a[i] < R ? R++
        // a[i] >= R ? 更新 a[i] = a[R]+1, R++

    }

}

/*
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

 

示例 1:

输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:

输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 

提示：

1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
