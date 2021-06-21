package me.arithmetic.array;

import java.util.Arrays;

/**
 * @author: 囧么肥事
 * @description: 645. 错误的集合
 * @date: 2021/6/20
 */
public class FindErrorNums {

    // 将第一次遇到的数变为负数
    // 再次遇到时，查询已经变为负数，那么这个数就是重复数
    public static int[] findErrorNums2(int[] nums) {

        //        1 2 4 3 3 3 4
        // a[0]  -1 2 4 3 3 3 4
        // a[1]  -1 -2 4 3 3 3 4
        // a[2]  -1 -2 4 -3 3 3 4

        int[] res = new int[2];
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                // 重复数
                res[0] = Math.abs(num);
            } else {
                // 第一次访问元素，置为0
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        // 遍历数组，找到数组中正值元素所在位置，即为缺失数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }

    // 辅助数组
    public static int[] findErrorNums1(int[] nums) {

        // 辅助数组，数据是从 1~N，所以长度 +1
        int[] help = new int[nums.length + 1];

        // 根据nums 修改辅助数组，统计nums 元素出现次数
        for (int num : nums) {
            help[num]++;
        }

        // 遍历辅助数组
        // 次数大于1的是重复数
        // 次数等于0的是缺失数
        int[] res = new int[2];
        for (int i = 1; i < help.length; i++) {
            if (help[i] > 1) {
                res[0] = i;
            }
            if (help[i] == 0) {
                res[1] = i;
            }
        }

        return res;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 4};
        int[] arr = {2, 2};
        System.out.println(Arrays.toString(findErrorNums1(arr)));
        System.out.println(Arrays.toString(findErrorNums2(arr)));
    }
}



/*
集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，

导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，

导致集合 丢失了一个数字 并且 有一个数字重复 。

给定一个数组 nums 代表了集合 S 发生错误后的结果。

请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

 

示例 1：

输入：nums = [1,2,2,4]
输出：[2,3]
示例 2：

输入：nums = [1,1]
输出：[1,2]
 

提示：

2 <= nums.length <= 104
1 <= nums[i] <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-mismatch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
