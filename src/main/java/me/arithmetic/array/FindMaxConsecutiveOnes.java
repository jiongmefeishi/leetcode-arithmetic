package me.arithmetic.array;

/**
 * @author: 囧么肥事
 * @date: 2021/6/8 15:40
 * @description: 485. 最大连续 1 的个数
 */
public class FindMaxConsecutiveOnes {

    // 滑动窗口
    public static int findMaxConsecutiveOnes3(int[] nums) {

        int left = 0;
        int right = 0;
        int maxCount = 0;
        // 循环窗口关闭条件：右侧窗口抵达数组边界
        while (right < nums.length) {

            if (nums[right] == 1) {
                // 如果元素是1，窗口扩增
                right++;
                continue;
            } else {
                // 如果元素是0，记录窗口大小，即当前窗口最大连续个数
                maxCount = Math.max(maxCount, right - left);
                right++;
                // 重置左窗口起点
                left = right;
            }
        }

        maxCount = Math.max(maxCount, right - left);
        return maxCount;
    }

    // 滑动窗口
    public static int findMaxConsecutiveOnes2(int[] nums) {

        int left = 0;
        int right = 0;
        int maxCount = 0;
        // 循环窗口关闭条件：右侧窗口抵达数组边界
        while (right < nums.length) {

            if (nums[right] == 1) {
                // 如果元素是1，窗口扩增
                right++;
                continue;
            }

            // 如果元素是0，记录窗口大小，即当前窗口最大连续个数
            maxCount = Math.max(maxCount, right - left);

            // 跳过为0段
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            // 重置左窗口起点
            left = right;
        }

        maxCount = Math.max(maxCount, right - left);
        return maxCount;
    }

    // 计数法
    public static int findMaxConsecutiveOnes1(int[] nums) {

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
        System.out.println(findMaxConsecutiveOnes1(array));
        System.out.println(findMaxConsecutiveOnes2(array));
        System.out.println(findMaxConsecutiveOnes3(array));
    }

}
