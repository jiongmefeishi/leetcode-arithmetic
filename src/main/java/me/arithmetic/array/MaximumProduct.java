package me.arithmetic.array;

/**
 * @author: zqtao
 * @date: 2021/6/18 17:10
 * @description: 628. 三个数的最大乘积
 */
public class MaximumProduct {

    // 类似 414.第三大的数
    // 三个数的最大乘积
    // 假设数组是有序
    // 如果元素都是非负数或者都是非正数，最大乘积=最大的三个数的乘积
    // 如果元素有正有负，最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积

    // 给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。
    public static int maximumProduct(int[] nums) {

        return 0;
    }
}

/*
给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

 

示例 1：

输入：nums = [1,2,3]
输出：6
示例 2：

输入：nums = [1,2,3,4]
输出：24
示例 3：

输入：nums = [-1,-2,-3]
输出：-6
 

提示：

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
