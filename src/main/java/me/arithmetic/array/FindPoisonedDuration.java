package me.arithmetic.array;

/**
 * @author: 囧么肥事
 * @date: 2021/6/15 14:33
 * @description: 495.提莫攻击
 */
public class FindPoisonedDuration {

    // 思考
    // 每一次考虑下一次中毒时间只有两种可能
    // 第一种，不与上一段时间重合，自己就是完整的持续时间段，这是最大持续时间
    // 第二种，部分时间与上一段时间重合，需要减去重合时间段，这是较小持续时间
    // 第二种情况下，算得的较小持续时间一定是小于 第一种情况的，即 duration 的
    // 所以，取两种情况的最小值，就是下一次中毒持续时间
    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }

        // 第一次中毒持续时间
        int durationTime = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            durationTime += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return durationTime;
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }

        // 第一次中毒持续时间
        int durationTime = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            // 计算下一次中毒持续时间
            if (timeSeries[i + 1] >= timeSeries[i] + duration) {
                // 下一次中毒开始时间大于等于上一次中毒结束时间，那么下一次中毒持续时间为完整时间段
                durationTime += duration;
            } else {
                // 下一次中毒开始时间小于上一次中毒结束时间，那么下一次中毒时间需要减去公共时间段
                durationTime += timeSeries[i + 1] - timeSeries[i];
            }
        }

        return durationTime;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6};
//        System.out.println(findPoisonedDuration(arr, 3));
//        int[] arr1 = {1, 4};
//        System.out.println(findPoisonedDuration(arr1, 2));
//        int[] arr2 = {1, 2};
//        System.out.println(findPoisonedDuration(arr2, 2));
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findPoisonedDuration2(arr3, 1));
    }
}



/*
在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，

他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。

现在，给出提莫对艾希的

攻击时间序列

和提莫攻击的

中毒持续时间，

你需要输出艾希的中毒状态总时长。

你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。

 

示例1:

输入: [1,4], 2
输出: 4
原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
所以最终输出 4 秒。
示例2:

输入: [1,2], 2
输出: 3
原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
所以最终输出 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/teemo-attacking
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
