package me.arithmetic.array;

import java.util.Arrays;

/**
 * @author: zqtao
 * @date: 2021/7/14 16:57
 * @description: 661. 图片平滑器
 */
public class ImageSmoother {

    public static int[][] imageSmoother2(int[][] img) {

        // 二维数组行数
        int rowNums = img.length;
        // 二维数组列数
        int colNums = img[0].length;

        int[][] res = new int[rowNums][colNums];


        for (int i = 0; i < rowNums; i++) {

            for (int j = 0; j < colNums; j++) {

                // 当前战士 a[i][j]
                // 划分小型阵列，找到阵列边界
                // 判断前后左右是否有队列

                // 前方队列
                int si = i - 1;
                // 后方队列
                int ei = i + 1;
                // 左边队列
                int sj = j - 1;
                // 右边队列
                int ej = j + 1;

                int count = 0;
                int sum = 0;

                // 报数
                for (int rowI = si; rowI <= ei; rowI++) {
                    for (int colI = sj; colI <= ej; colI++) {
                        // 判断小型阵列是否在大阵列内
                        // 只有在阵列内，才是有效阵列
                        if (rowI >= 0 && rowI < rowNums && colI >= 0 && colI < colNums) {
                            sum += img[rowI][colI];
                            count++;
                        }
                    }
                }


                res[i][j] = (sum / count);
            }
        }

        return res;
    }

    // a[i][j]
    // 判断左方是否存在
    // 判断左上是否存在
    // 判断上方是否存在
    // 判断右上是否存在
    // 判断右方是否存在
    // 判断右下是否存在
    // 判断下方是否存在
    // 判断左下是否存在
    public static int[][] imageSmoother(int[][] img) {

        // 二维数组行数
        int rowNums = img.length;
        // 二维数组列数
        int colNums = img[0].length;

        int[][] res = new int[rowNums][colNums];


        for (int i = 0; i < rowNums; i++) {

            for (int j = 0; j < colNums; j++) {
                int count = 1;
                int sum = img[i][j];

                // a[i][j]
                // 判断左方是否存在
                if (j - 1 >= 0) {
                    count++;
                    sum += img[i][j - 1];
                }
                // 判断左上是否存在
                if (i - 1 >= 0 && j - 1 >= 0) {
                    count++;
                    sum += img[i - 1][j - 1];
                }
                // 判断上方是否存在
                if (i - 1 >= 0) {
                    count++;
                    sum += img[i - 1][j];
                }
                // 判断右上是否存在
                if (i - 1 >= 0 && j + 1 < colNums) {
                    count++;
                    sum += img[i - 1][j + 1];
                }
                // 判断右方是否存在
                if (j + 1 < colNums) {
                    count++;
                    sum += img[i][j + 1];
                }
                // 判断右下是否存在
                if (i + 1 < rowNums && j + 1 < colNums) {
                    count++;
                    sum += img[i + 1][j + 1];
                }
                // 判断下方是否存在
                if (i + 1 < rowNums) {
                    count++;
                    sum += img[i + 1][j];
                }
                // 判断左下是否存在
                if (i + 1 < rowNums && j - 1 >= 0) {
                    count++;
                    sum += img[i + 1][j - 1];
                }

                res[i][j] = (sum / count);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] img = new int[3][];
        img[0] = new int[]{1, 1, 5, 2};
        img[1] = new int[]{0, 5, 3, 3};
        img[2] = new int[]{9, 2, 2, 1};

        int[][] res = imageSmoother(img);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        System.out.println("==========");

        int[][] res2 = imageSmoother2(img);

        for (int i = 0; i < res2.length; i++) {
            System.out.println(Arrays.toString(res2[i]));
        }

        /*
[1, 2, 3, 3]
[3, 3, 2, 2]
[4, 3, 2, 2]
==========
[1, 2, 2, 0]
[2, 2, 2, 0]
[0, 0, 0, 0]
         */
    }

}

/*
包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。

示例 1:

输入:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
注意:

给定矩阵中的整数范围为 [0, 255]。
矩阵的长和宽的范围均为 [1, 150]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/image-smoother
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
