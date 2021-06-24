package me.arithmetic.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 囧么肥事
 * @date: 2021/6/15 14:33
 * @description: 697. 数组的度
 */
public class FindShortestSubArray {


    public static int findShortestSubArray(int[] nums) {

        // 记录最短连续子数组长度
        int min = Integer.MAX_VALUE;
        // 记录最大数组度
        int maxCount = 0;

        // 存储每个元素对应出现次数
        Map<Integer, Integer> count = new HashMap<>();
        // 存储每个元素首次出现位置
        Map<Integer, Integer> leftIndex = new HashMap<>();
        // 存储每个元素最后一次出现的位置
        Map<Integer, Integer> rightIndex = new HashMap<>();

        // 第一次遍历，遍历nums[]，记录每个元素出现次数，出现位置，以及数组的度
        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == null) {
                count.put(nums[i], 1);
                leftIndex.put(nums[i], i);
            } else {
                count.put(nums[i], count.get(nums[i]) + 1);
            }
            rightIndex.put(nums[i], i);
            maxCount = Math.max(maxCount, count.get(nums[i]));
        }

        // 第二次遍历，遍历 count 根据数组的度，计算最小连续子数组长度
        for (Integer key: count.keySet()) {
            if (count.get(key) == maxCount) {
                // 连续子数组长度=右边界-左边界+1
                min = Math.min(min, rightIndex.get(key) - leftIndex.get(key) + 1);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(arr));

        int[] arr2 = {1, 2, 2, 3, 1, 4, 2};
//        int[] arr2 = {2, 2};
        System.out.println(findShortestSubArray(arr2));
    }
}
