package me.arithmetic.array;

/**
 * @author: 囧么肥事
 * @date: 2021/6/8 15:40
 * @description: 485. 最大连续 1 的个数
 */
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        // 记录最大个数
        int maxCount = 0;
        // 记录连续1个数
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 取最大连续数
                maxCount = Math.max(maxCount, count);
                // 重置连续个数
                count = 0;
            } else {
                count++;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(array));
    }

}
