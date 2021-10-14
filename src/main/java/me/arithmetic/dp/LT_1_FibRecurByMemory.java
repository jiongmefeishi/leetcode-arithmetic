package me.arithmetic.dp;


import java.util.HashMap;
import java.util.Map;

// 509. 斐波那契数
public class LT_1_FibRecurByMemory {

    // 暴力递归 + 备忘录
    public static int fib(int n) {
        return recur(n, new HashMap<>());
    }

    public static int recur(int n, Map<Integer, Integer> memory) {
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int fn = fib(n - 1) + fib(n - 2);
        memory.put(n, fn);
        return fn;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(fib(50));
        System.out.println(System.currentTimeMillis() - l);
    }
}

