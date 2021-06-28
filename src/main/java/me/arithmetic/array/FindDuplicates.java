package me.arithmetic.array;

import java.util.ArrayList;
import java.util.List;
/**
 * @author: zqtao
 * @date: 2021/6/24 14:35
 * @description: 442. 数组中重复的数据
 */
public class FindDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                // 再次遇到，则为重复数
                res.add(Math.abs(n));
            } else {
                // 首次遇到，将元素对应位置数反转
                nums[Math.abs(n) - 1] *= -1;
            }

        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }
}
/*
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
