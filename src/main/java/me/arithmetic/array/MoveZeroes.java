package me.arithmetic.array;

import java.util.Arrays;

/**
 * @author: zqtao
 * @date: 2021/7/19 16:31
 * @description: 283. 移动零
 */
public class MoveZeroes {

    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]

    // 双指针
    // 0 1 0 3 12       L=0, R=0 初始化
    // 0 1 0 3 12       L=0, R=1 交换 arr[0], arr[1]
    // 1 0 0 3 12       L=1, R=3 交换 arr[1], arr[2]
    // 1 3 0 0 12       L=2, R=4 交换 arr[2], arr[4]
    // 1 3 12 0 0
    public static void moveZeroes(int[] nums) {
        int L = 0;
        int R = 0;
        while (R < nums.length) {
            if (nums[R] != 0) {
                swap(nums, L++, R);
            }
            R++;
        }
    }

    // 交换L，R下标对应数据
    public static void swap(int[] arr, int L, int R) {
        int tmp = arr[L];
        arr[L] = arr[R];
        arr[R] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
