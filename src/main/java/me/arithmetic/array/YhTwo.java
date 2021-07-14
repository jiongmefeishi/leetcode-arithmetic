package me.arithmetic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zqtao
 * @date: 2021/7/14 15:24
 * @description: 119 杨辉三角2
 */
public class YhTwo {

    // 计算公式
    // a[i][j] = a[i - 1][j - 1] + a[i - 1][j]
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i; j++) {
                if (i == 0) {
                    continue;
                }
                if (i == j) {
                    row.add(1);
                    continue;
                }
                row.add(res.get(j - 1) + res.get(j));
            }
            res = row;
        }
        return res;
    }

    // 计算公式
    // a[i][j] = a[i - 1][j - 1] + a[i - 1][j]
    public static List<Integer> getRow2(int rowIndex) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i; j++) {
                if (i == 0) {
                    continue;
                }
                if (i == j) {
                    row.add(1);
                    continue;
                }
                row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(row);
        }
        return res.get(rowIndex - 1);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
