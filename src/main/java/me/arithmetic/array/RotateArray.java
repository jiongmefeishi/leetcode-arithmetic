package me.arithmetic.array;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] help = new int[n];
        for (int i = 0; i < n; ++i) {
            // 旋转 k, 相当于 nums[i] 元素向后跨步 k 个下标
            // nums 数组下标范围是 [0, N-1]
            // 跨步后下标超过N-1，从 0 继续跨步
            // 计算 nums[i] 旋转后在辅助数组中的相对位置
            int m = (i + k) % n;
            help[m] = nums[i];
        }
        System.arraycopy(help, 0, nums, 0, n);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {-1, -100, 3, 99};
        int[] nums = {-1};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 

进阶：

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 

示例 1:

输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
 

提示：

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
