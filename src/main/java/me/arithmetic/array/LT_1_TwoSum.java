package me.arithmetic.array;

import java.util.HashMap;
import java.util.Map;

// 在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标。
public class LT_1_TwoSum {

    // 解题思路
    // 顺序扫描数组，针对于数组中的每一个元素，尝试在 map 中找到能组合成 target 的另一半，
    // 如果找到了，获取下标
    // 如果找不到，加入 map
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
