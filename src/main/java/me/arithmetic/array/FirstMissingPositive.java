package me.arithmetic.array;

/**
 * @author: zqtao
 * @date: 2021/6/24 14:45
 * @description: 41. 缺失的第一个正数
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        // 缺失数一定出现在 [1, N+1] 范围内
        // 取得数组长度为 N
        // 第一次遍历，将所有非正数修改为 N+1
        int N = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = N + 1;
            }
        }

        // 第二次遍历，打标记，将元素属于 1 ~ N 范围内的数反转
        for (int i = 0; i < nums.length; i++) {
            
        }

        return 0;
    }
}

/*
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 

示例 1：

输入：nums = [1,2,0]
输出：3
示例 2：

输入：nums = [3,4,-1,1]
输出：2
示例 3：

输入：nums = [7,8,9,11,12]
输出：1

提示：

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-missing-positive
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
