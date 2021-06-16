package me.arithmetic.array;

/**
 * @author: 囧么肥事
 * @date: 2021/6/15 16:31
 * @description: 414.第三大的数
 */
public class ThirdMax {
    public static int thirdMax(int[] nums) {

        // 处理不够三个元素的情况
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // 定义三个临时变量，分别保存最大值，第二大值，第三大值
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        boolean modify = false;

        // 循环数组，依次更新，每次更新顺序为 third，second，first
        for (int n : nums) {

            // 大于最大值
            if (n > first) {
                third = second;
                second = first;
                first = n;
                modify = true;
            } else if (n > second && n != first) {
                // 大于第二大值，但是不等于最大值，等于最大值无需更新
                third = second;
                second = n;
                modify = true;
            } else if (n >= third && n != first && n != second) {
                // 大于第三大值，但是不等于第一，第二大值
                third = n;
                modify = true;
            }
        }
        return modify && third != Integer.MIN_VALUE ? third : first;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 5, 6, 2};
//        System.out.println(thirdMax(arr));
//
//
//        int[] arr1 = {1, 5, 6, 2, Integer.MAX_VALUE};
//        System.out.println(thirdMax(arr1));
//
//        int[] arr2 = {1, 1, 2};
//        System.out.println(thirdMax(arr2));

        int[] arr3 = {1, 2, Integer.MIN_VALUE};
        System.out.println(thirdMax(arr3));
    }
}


/*
给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

 

示例 1：

输入：[3, 2, 1]
输出：1
解释：第三大的数是 1 。
示例 2：

输入：[1, 2]
输出：2
解释：第三大的数不存在, 所以返回最大的数 2 。
示例 3：

输入：[2, 2, 3, 1]
输出：1
解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 

提示：

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/third-maximum-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        #长度小于3的，直接返回最大值
        ll_nums = list(set(nums))
        if len(ll_nums) < 3:
            return max(ll_nums)
        #初始化最大值，次大值，第三大值
        a = b = c = float('-inf')
        #遍历列表：
        for num in nums:
            #大于最大值，依次更新，这里要注意更新顺序，先更新c, 然后b, 最后a
            if num > a:
                c = b
                b = a
                a = num
            #更新次大值
            elif num > b and num != a:
                c = b
                b = num
            #更新第三大值
            elif num > c and num != a and num != b:
                c = num
        return c

作者：JonnyHuang
链接：https://leetcode-cn.com/problems/third-maximum-number/solution/python3-yi-ci-bian-li-mei-ci-bao-cun-gen-iol7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
