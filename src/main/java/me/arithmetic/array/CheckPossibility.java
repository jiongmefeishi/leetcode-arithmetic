package me.arithmetic.array;

import java.util.Arrays;

/**
 * @author: zqtao
 * @date: 2021/7/2 17:25
 * @description: 665. 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/
 */
public class CheckPossibility {

    // nums[i] <= nums[i + 1]
    public static boolean checkPossibility(int[] nums) {

        // 4 2 3 4
        // 从右往左遍历，以a[i] 为开始  a[i]~a[N-1] 范围内的数都是递增序列
        // a[i] < a[L] ? L--
        // a[i] >= a[L] ? 更新 a[i] = a[L]-1, L--

        // 从左往右遍历，以a[i] 为结束  a[0]~a[i]   范围内的数都是递增序列
        // a[i] < a[R] ? R++
        // a[i] >= a[R] ? 更新 a[i] = a[R]+1, R++

        int[] copy = Arrays.copyOf(nums, nums.length);

        int L = nums.length - 1;
        int R = 0;

        int countR = 0;
        // 从左往右遍历
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[R]) {
                nums[i] = nums[R] + 1;
                countR++;
            }
            R++;
        }

        nums = copy;
        int countL = 0;
        // 从右往左遍历
        for (int i = L - 1; i >= 0; i--) {
            if (nums[i] > nums[L]) {
                nums[i] = nums[L] - 1;
                countL++;
            }
            L--;
        }

        if (countL <= 1 || countR <= 1) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//        int[] arr = {4, 1, 2, 3};
//        int[] arr = {4};
        int[] arr = {7, 5, 3, 6};
        System.out.println(checkPossibility(arr));
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
