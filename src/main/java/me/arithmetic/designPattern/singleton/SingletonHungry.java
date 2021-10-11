package me.arithmetic.designPattern.singleton;

/**
 * @author: zqtao
 * @date: 2021/10/8 15:13
 * @description: 单例模式，饿汉式
 *
 * 特点
 * 1、提前创建（类加载就创建）
 * 2、没有多线程同步问题
 *
 * 实现
 * 1、私有化构造函数
 * 2、提供get方法
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public SingletonHungry getInstance() {
        return instance;
    }
}
