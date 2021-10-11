package me.arithmetic.designPattern.singleton;

/**
 * @author: zqtao
 * @date: 2021/10/8 15:36
 * @description: 懒汉式-静态内部类
 * <p>
 * 特点
 * Holder 静态内部类：外部类加载时，并不会直接导致静态内部类被加载，在调用 getInstance() 时才会触发该静态内部类被加载，所以，可以延时执行。
 * Holder.instance static 字段：同一个加载器下，一个类型只会初始化一次，故天然的线程安全。
 * <p>
 * 优点：静态内部类 相比 DCL 代码简洁很多，即有饿汉式的优势（线程安全），又可以做到延时初始化
 * 缺点：看似很完美，但其有一个致命问题，即无法传参，所以，实际开发中，要根据实际情况来选择其中一种实现方式。
 */
public class SingletonLazyClass {

    public static class Holder {
        private static SingletonLazyClass instance = new SingletonLazyClass();
    }

    private SingletonLazyClass() {
    }

    public static SingletonLazyClass getInstance() {
        return Holder.instance;
    }

}
