package me.arithmetic.designPattern.singleton;
/**
 * @author: zqtao
 * @date: 2021/10/8 15:31
 * @description: 懒汉式
 *
 * 特点
 * 1、延迟创建对象
 * 2、优点：需要用到时才会创建对象，规避不必要的内存浪费
 * 3、缺点：可能需要考虑有多线程同步问题
 */
public class SingletonLazyDCL {

    private volatile SingletonLazyDCL instance;

    // DCL (+ volatile) 方式
    // DCL，即双重检查锁定 （Double-Checked-Locking）

    // 实现原理
    // synchronized 之前第一次判空，避免不必要的加锁同步，提高性能
    // synchronized 之后第二次判空，避免多线程安全问题
    // volatile 修饰instance，避免指令重排序问题
    private SingletonLazyDCL() {

    }

    public SingletonLazyDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDCL.class) {
                if (instance == null) {
                    instance = new SingletonLazyDCL();
                }
            }
        }
        return instance;
    }

}
