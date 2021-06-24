package me.arithmetic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zqtao
 * @date: 2021/6/24 10:53
 * @description: 448. 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

    // 修改原数组状态，遇到 a[i] 则将 下标为 i - 1 的位置反转为负数
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // 将元素对应下标位置反转为负数
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] > 0) {
                nums[Math.abs(n)  - 1] *= -1;
            }
        }

        List<Integer> res = new ArrayList<>();
        // 遍历数组，下标位置为正数的是缺失数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }


    // 辅助数组
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        int[] help = new int[nums.length + 1];

        for (int n : nums) {
            help[n] = 1;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < help.length; i++) {
            if (help[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//        int[] nums = {1, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}


/*
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

 

示例 1：

输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]
示例 2：

输入：nums = [1,1]
输出：[2]
 

提示：

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
