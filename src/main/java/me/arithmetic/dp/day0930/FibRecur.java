package me.arithmetic.dp.day0930;

// 509. 斐波那契数
public class FibRecur {

    // 暴力递归
    public static int fib(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(fib(50));
        System.out.println(System.currentTimeMillis() - l);
    }
}
