package me.arithmetic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zqtao
 * @date: 2021/7/14 15:24
 * @description: 118. 杨辉三角
 */
public class YhOne {

    // 计算公式
    // a[i][j] = a[i - 1][j - 1] + a[i - 1][j]
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
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
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
